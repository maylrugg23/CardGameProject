package student;
import java.util.Random;

/**
 * The Deck class shows a standard deck of 52 playing cards.
 * It shuffles the deck, draw cards from it, and track the number of remaining cards.
 * If the deck is empty, it will reshuffle and continue drawing cards.
 */
public class Deck {

    /**
     * Array holding all 52 Card objects in the deck.
     */
    private final Card[] deck;

    /**
     * Index of the next card that will be drawn from the deck.
     */
    private int nextToDraw;

    /**
     * Tracks the number of cards drawn from the deck.
     */
    private int cardsGone;

    /**
     * Constructs a deck of 52 cards, initializes their values, and shuffles the deck.
     */
    public Deck() {
        this.deck = new Card[52];
        this.nextToDraw = 0;
        this.cardsGone = 0;

        int index = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                // Increment index
                this.deck[index++] = new Card(rank, suit);
            }
        }

        shuffle();
    }

    /**
     * Shuffles the deck of cards randomly, ensuring an even distribution.
     * Resets the `cardsGone` counter to zero to indicate all cards are available.
     */
    public void shuffle() {
        Random random = new Random();

        // Loop over the deck from the last card to the second card
        for (int i = 0; i < deck.length; i++) {
            // Generate a random index j between i and the last index of the deck
            int j = random.nextInt(deck.length - i) + i;

            // Swap the cards at index i and j
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    /**
     * Draws a card from the deck. If the deck is empty, the deck is reshuffled, and the first card is returned.
     * After each draw, the `nextToDraw` index is updated to point to the following card,
     * wrapping around to the start of the deck if the end is reached.
     * @return the next Card in the deck
     */
    public Card draw() {
        if (isEmpty()) {
            shuffle();
            nextToDraw = 0;
            cardsGone = 1;
        } else {
            // Increment and wrap around to 0 if at the end
            nextToDraw = (nextToDraw + 1) % 52;
            cardsGone++;
        }
        return deck[nextToDraw];
    }

    /**
     * Determines the number of cards remaining in the deck.
     * @return number of cards left in the deck.
     */
    public int cardsRemaining() {
        return deck.length - cardsGone;
    }

    /**
     * Determines if deck is empty.
     * @return if there are no more cards in the deck.
     */
    public boolean isEmpty() {
        return cardsGone == 52;
    }
}
