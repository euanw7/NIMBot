/**
 * TwoPileGame.java
 * @author Euan Watkins
 * @version 1.0
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class allows a two pile game of NIM to be played between a user and a bot.
 * The user can never win this game, however there is code to run if the user
 * does somehow win to prevent any possible crashes.
 */
public class TwoPileGame {

    // Two pile objects representing the two piles.
    private Pile p1;
    private Pile p2;

    // Constructs the piles for the game.
    public TwoPileGame(int n1, int n2) {
        p1 = new Pile(n1);
        p2 = new Pile(n2);
    }

    /**
     * This method starts the game by determining who goes first.
     * If the first position is a losing position the user will go first.
     * If the first position is a winning position the bot will go first.
     */
    public void start() {
        System.out.println("\n### GAME START ###");
        if (hasWinningStrategy() == 2) {
            System.out.println("\nYou are Player 1\nNIMBot is Player 2");
            userTurn();
        } else {
            System.out.println("\nNIMBot is Player 1\nYou are Player 2");
            botTurn();
        }
    }

    /**
     * This method will allow the user to take their turn by selecting
     * which pile to take from and how many cons to take.
     */
    private void userTurn() {
        System.out.println("\nPile 1: " + p1.getCoins() +
                "\nPile 2: " + p2.getCoins() +
                "\n\nWhich pile will you take from? (1/2)");

        // User chooses which pile they want to take from.
        int pileChoice;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.print(">>>: ");
                pileChoice = scan.nextInt();
            } catch (InputMismatchException i) {
                pileChoice = 0;
                scan.next();
            }
        } while (pileChoice != 1 && pileChoice != 2);

        // User chooses how many coins to take.
        System.out.println("\nHow many coins will you take?");
        if (pileChoice == 1) {
            takeCoins(p1, scan);
        } else {
            takeCoins(p2, scan);
        }

        // If the game has ended, run the end() method and tell it the user has won.
        // If not run the bots turn.
        if (gameEnd()) {
            end("user");
        } else {
            botTurn();
        }

    }

    /**
     * This method will allow the user to choose an amount of coins to take
     * from their selected pile.
     * @param p The selected pile.
     * @param scan The scanner object used to read the users input.
     */
    private void takeCoins(Pile p, Scanner scan) {
        int coinChoice;
        // Do this while the user gives an integer that's out of range.
        do {
            // Try to take an integer input.
            try {
                System.out.print(">>>: ");
                coinChoice = scan.nextInt();
            // If input is not an integer, skip and ask again.
            } catch (InputMismatchException i) {
                coinChoice = 0;
                scan.next();
            }
        } while (coinChoice < 1 || coinChoice > p.getCoins());
        p.take(coinChoice);
    }

    /**
     * This method will simulate a bot taking a turn. It will make a turn
     * so that the user ends up in a losing position.
     */
    private void botTurn() {
        // Integers representing which pile and how many coins the bot chooses.
        int botPile = 0;
        int botCoin = 0;

        // Bot has lost.
        if (p1.getCoins() == p2.getCoins()) {
            botPile = 1;
            botCoin = 1;
            p1.take(1);

            // Bot has won
        } else if (p1.getCoins() == 0) {
            botPile = 2;
            botCoin = p2.getCoins();
            p2.take(botCoin);

            // Bot has won
        } else if (p2.getCoins() == 0) {
            botPile = 1;
            botCoin = p1.getCoins();
            p1.take(botCoin);

            // Bot has winning strategy
        } else if (p1.getCoins() != p2.getCoins()) {
            if (p1.getCoins() > p2.getCoins()) {
                botPile = 1;
                botCoin = p1.getCoins() - p2.getCoins();
                p1.take(botCoin);
            } else if (p2.getCoins() > p1.getCoins()) {
                botPile = 2;
                botCoin = p2.getCoins() - p1.getCoins();
                p2.take(botCoin);
            }
        }

        // Message to the screen to inform the user of the bots decisions.
        System.out.println("\nNIMBot takes " + botCoin + "  coin(s) from pile " + botPile);
        // If the game has ended, run the end() method and tell it the bot has won.
        // Otherwise, begin the users turn.
        if (gameEnd()) {
            end("bot");
        } else {
            userTurn();
        }

    }

    /**
     * Returns an integer to determine which player has the winning strategy.
     *
     * @return 1 if player 1 has the winning strategy, 2 if player 2 has it.
     */
    private int hasWinningStrategy() {
        if (p1.getCoins() != p2.getCoins()) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Returns a boolean to determine if the game has ended.
     *
     * @return true if the game has ended, false if not.
     */
    private boolean gameEnd() {
        return p1.getCoins() == 0 && p2.getCoins() == 0;
    }

    /**
     * This method ends the game by displaying a message to inform
     * the user who has won.
     *
     * @param winner A string representing the winner of the game.
     */
    private void end(String winner) {
        if (winner.equals("user")) {
            System.out.println("\nOh... you won? That wasn't meant to happen. +" +
                    "\nWell done!");
        } else {
            System.out.println("\nNIMBot wins! Better luck next time.");
        }
        System.out.println("\n### GAME END ###");
    }

}
