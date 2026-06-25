package com.NumberQuest.Model;

import java.util.Random;

public class GameModel {
 
 // Generate a random target number (1–100) Validate every guess and return a typed GuessResult
 // Track attempts used per round Detect win and game-over states
 // Reset state cleanly for a new round

 
    // Constants
    public static final int MIN_NUMBER    = 1;
    public static final int MAX_NUMBER    = 100;
    public static final int MAX_ATTEMPTS  = 10;
 
    // State 
    private final Random random;
    private int targetNumber;
    private int attemptsUsed;
    private boolean isWon;
    private boolean isGameOver;
 
    // Constructor
    public GameModel() {
        this.random = new Random();
        resetRound();
    }
 
    // Validates a guess against the current target number.
    // Increments attempt counter on every valid guess.
     
    // @param guess The integer guess submitted by the user
    // @return GuessResult enum — TOO_HIGH, TOO_LOW, CORRECT, or OUT_OF_RANGE
    
    public GuessResult validateGuess(int guess) {
 
        // out of range input
        if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
            return GuessResult.OUT_OF_RANGE;
        }
 
        attemptsUsed++;
 
        if (guess == targetNumber) {
            isWon      = true;
            isGameOver = true;
            return GuessResult.CORRECT;
 
        } else if (guess > targetNumber) {
            checkGameOver();
            return GuessResult.TOO_HIGH;
 
        } else {
            checkGameOver();
            return GuessResult.TOO_LOW;
        }
    }
 
    // Resets all round state and generates a new target number.
    public void resetRound() {
    	
        // Zero-Index Shift: nextInt(100) → 0–99, +1 → 1–100
        this.targetNumber  = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
        this.attemptsUsed  = 0;
        this.isWon         = false;
        this.isGameOver    = false;
    }
 
    // Getters
    // Returns how many attempts the user has left 
    public int getRemainingAttempts() {
        return MAX_ATTEMPTS - attemptsUsed;
    }
 
    // Returns how many attempts the user has used 
    public int getAttemptsUsed() {
        return attemptsUsed;
    }
 
    public double getAttemptsRatio() {
        return (double) attemptsUsed / MAX_ATTEMPTS;
    }
 
    // True if the player correctly guessed the number 
    public boolean isWon() {
        return isWon;
    }
 
    // True if attempts are exhausted OR the player has won 
    public boolean isGameOver() {
        return isGameOver;
    }
    
    public int getTargetNumber() {
        return targetNumber;
    }
 
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }
 
    // Sets game over if no attempts remain 
    private void checkGameOver() {
        if (attemptsUsed >= MAX_ATTEMPTS) {
            isGameOver = true;
        }
    }
}