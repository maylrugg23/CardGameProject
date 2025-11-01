package student;

/**
 * The Hand class represents a collection of cards drawn from a deck.
 * It allows cards to be drawn into the hand, accessed by index, and removed,
 * replacing any removed cards with new ones from the deck.
 */
public class Hand {

    /**
     * The deck from which cards are drawn to populate the hand.
     */
    private final Deck deck;

    /**
     * Size of the hand.
     */
    private final int size;

    /**
     * An array holding the cards in the hand.
     */
    private final Card[] hand;

    /**
     * Constructs a hand of cards by drawing the specified number of cards from the given deck.
     * @param deck where cards draw from
     * @param size number of cards to draw for the hand
     */
    public Hand(Deck deck, int size) {
        this.deck = deck;
        this.size = size;
        this.hand = new Card[size];
        // Draw cards from the deck to fill the hand
        for (int i = 0; i < size; i++) {
            hand[i] = deck.draw();
        }
    }

    /**
     * Gets size of hand.
     * @return size of hand.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets card of index i in hand.
     * @param i is index of card in hand array.
     * @return Card with index i in array.
     */
    public Card get(int i) {
        if (i < 0 || i > size) {
            System.out.println("Invalid hand index!");
            return hand[0];
        }
        return hand[i];
    }

    /**
     * Removes a card from hand and replaces it with new card from the deck.
     * @param card to be removed.
     * @return true if card is able to be removed, false if not
     */
    public boolean remove(Card card) {
        // Find the index of the card to remove
        int indexToRemove = -1;
        for (int i = 0; i < size; i++) {
            if (hand[i].equals(card)) {
                indexToRemove = i;
                break;
            }
        }
        // If the card was not found, return false
        if (indexToRemove == -1) {
            return false;
        }
        // Replace the removed card with a new one from the deck
        hand[indexToRemove] = deck.draw();
        return true;
    }
}
