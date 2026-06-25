package com.NumberQuest.Model;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
 
    // Inner record to store each round's result 
    public static class RoundResult {
        public final int  roundNumber;
        public final int  attemptsUsed;
        public final int  score;
        public final boolean won;
 
        public RoundResult(int roundNumber, int attemptsUsed, int score, boolean won) {
            this.roundNumber  = roundNumber;
            this.attemptsUsed = attemptsUsed;
            this.score        = score;
            this.won          = won;
        }
    }
 
    // State
    private int currentRound;
    private int totalScore;
    private int bestScore;
    private int bestRound;
    private final List<RoundResult> history;
 
    // Constructor 
    public ScoreBoard() {
        this.currentRound = 0;
        this.totalScore   = 0;
        this.bestScore    = 0;
        this.bestRound    = 0;
        this.history      = new ArrayList<>();
    }

    public void recordRound(int attemptsUsed, boolean won) {
        currentRound++;
        int roundScore = calculateScore(attemptsUsed, won);
        totalScore    += roundScore;
 
        if (roundScore > bestScore) {
            bestScore = roundScore;
            bestRound = currentRound;
        }
 
        history.add(new RoundResult(currentRound, attemptsUsed, roundScore, won));
    }
 
    
    // Calculates points for a single round.
    // Public so GameController can preview score before recording.
     
    public int calculateScore(int attemptsUsed, boolean won) {
        if (!won) return 0;
        return Math.max(0, (GameModel.MAX_ATTEMPTS - attemptsUsed + 1) * 10);
    }
 
    // Resets entire scoreboard for a fresh session 
    public void resetSession() {
        currentRound = 0;
        totalScore   = 0;
        bestScore    = 0;
        bestRound    = 0;
        history.clear();
    }
 
    // Getters 
 
    public int getCurrentRound()      { return currentRound; }
    public int getTotalScore()        { return totalScore; }
    public int getBestScore()         { return bestScore; }
    public int getBestRound()         { return bestRound; }
    public List<RoundResult> getHistory() { return history; }
 
     // Returns the score of the most recently recorded round.
     // Returns 0 if no rounds have been played.
 
    public int getLastRoundScore() {
        if (history.isEmpty()) return 0;
        return history.get(history.size() - 1).score;
    }
 
     // Returns a formatted summary string for the end-of-session screen
    
    public String getSessionSummary() {
        int totalRounds = history.size();
        long wins = history.stream().filter(r -> r.won).count();
        return String.format(
            "Rounds: %d  |  Wins: %d  |  Total Score: %d  |  Best: %d pts (Round %d)",
            totalRounds, wins, totalScore, bestScore, bestRound
        );
    }
}
 