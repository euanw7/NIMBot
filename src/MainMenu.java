/**
 * MainMenu.java
 * @author Euan Watkins
 * @version 1.0
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains a single main method which will display a main menu
 * to the user. This menu allows them to decide how many coins are in each pile.
 */

public class MainMenu {
    public static void main(String[] args) {
        
        System.out.println("\n### MAIN MENU ###");
        Scanner scan = new Scanner(System.in);

        /**
         * Allows the user to choose the amount for the first pile.
         * Continues to ask for an input if their input is invalid.
         */
        int pile1;
        System.out.println("\nPlease input the amount of coins in the FIRST pile" + 
                "\n(Must be an integer between 0 and 20)");
        do {
            try {
                System.out.print(">>>: ");
                pile1 = scan.nextInt();
            } catch (InputMismatchException i) {
                pile1 = 0;
                scan.next();
            }
        } while (pile1 < 0 && pile1 > 20);

        /**
         * Allows the user to choose the amount for the second pile.
         * Continues to ask for an input if their input is invalid.
         */
        int pile2;
        System.out.println("\nPlease input the amount of coins in the SECOND pile" + 
                "\n(Must be an integer between 0 and 20)");
        do {
            try {
                System.out.print(">>>: ");
                pile2 = scan.nextInt();
            } catch (InputMismatchException i) {
                pile2 = 0;
                scan.next();
            }
        } while (pile2 < 0 && pile2 > 20);

        // Constructs a game with the chosen amounts for each pile then starts it.
        TwoPileGame g = new TwoPileGame(pile1,pile2);
        g.start();

    }

}
