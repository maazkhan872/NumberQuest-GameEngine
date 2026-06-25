package com.NumberQuest;

import java.util.Scanner;

import com.NumberQuest.Model.GameModel;
import com.NumberQuest.Model.GuessResult;
import com.NumberQuest.Model.ScoreBoard;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GameModel gameModel = new GameModel();
        ScoreBoard scoreBoard = new ScoreBoard();

        boolean playSession = true;

        System.out.println("      NUMBER QUEST GAME");

        while (playSession) {

            gameModel.resetRound();

            int rangeLow = GameModel.MIN_NUMBER;
            int rangeHigh = GameModel.MAX_NUMBER;

            System.out.println("\nNew Round Started!");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("Maximum Attempts: " + GameModel.MAX_ATTEMPTS);

            while (!gameModel.isGameOver()) {

                System.out.println("\nRemaining Attempts: "
                        + gameModel.getRemainingAttempts());

                System.out.print("Enter Guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid Input! Enter numbers only.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                GuessResult result = gameModel.validateGuess(guess);

                switch (result) {

                    case CORRECT:

                        int attemptsUsed = gameModel.getAttemptsUsed();

                        int roundScore =
                                scoreBoard.calculateScore(attemptsUsed, true);

                        scoreBoard.recordRound(attemptsUsed, true);

                        System.out.println(
                                "\nCORRECT! Number was "
                                        + gameModel.getTargetNumber());

                        System.out.println(
                                "Solved in "
                                        + attemptsUsed
                                        + " attempt(s)");

                        System.out.println(
                                "Round Score: "
                                        + roundScore);

                        break;

                    case TOO_HIGH:

                        rangeHigh = guess - 1;

                        System.out.println("Too High!");

                        System.out.println(
                                "Hint: Number is between "
                                        + rangeLow
                                        + " and "
                                        + rangeHigh);

                        break;

                    case TOO_LOW:

                        rangeLow = guess + 1;

                        System.out.println("Too Low!");

                        System.out.println(
                                "Hint: Number is between "
                                        + rangeLow
                                        + " and "
                                        + rangeHigh);

                        break;

                    case OUT_OF_RANGE:

                        System.out.println(
                                "Out of Range! Enter 1-100");

                        break;

                    default:
                        break;
                }
            }

            if (!gameModel.isWon()) {

                scoreBoard.recordRound(
                        gameModel.getAttemptsUsed(),
                        false);

                System.out.println(
                        "\nGAME OVER!");

                System.out.println(
                        "Correct Number Was: "
                                + gameModel.getTargetNumber());
            }

            System.out.println("\nSCOREBOARD");
            System.out.println(
                    "Round: "
                            + scoreBoard.getCurrentRound());

            System.out.println(
                    "Total Score: "
                            + scoreBoard.getTotalScore());

            System.out.println(
                    "Best Score: "
                            + scoreBoard.getBestScore());

            System.out.println(
                    scoreBoard.getSessionSummary());

            System.out.println("\nPlay Again? (Y/N)");

            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("Y")) {
                playSession = false;
            }
        }

        System.out.println("\nThanks for playing Number Quest!");
        scanner.close();
    }
}