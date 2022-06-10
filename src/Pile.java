/**
 * Pile.java
 * @author Euan Watkins
 * @version 1.0
 */

/**
 * This class constructs a pile of an arbitrary number of
 * coins for the game NIM.
 */
public class Pile {

    // The number of coins in the pile
    private int coins;

    /**
     * This constructs a pile of coins.
     * @param coins Integer of the number of coins in the pile.
     */
    public Pile(int coins) {
        this.coins = coins;
    }

    /**
     * Returns the number of coins in the pile.
     * @return Integer of the number of coins in the pile.
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Allows a player to take a number of coins from the pile.
     * @param n The number of coins to be taken from the pile.
     */
    public void take(int n) {
        coins -= n;
    }
}
