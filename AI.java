package student;

/**
 * The AI class provides a baseline AI strategy for card playing, where the AI picks the
 * first valid card from its hand that can be played on the current card pile. This class serves as
 * the foundation for more advanced AI strategies in subclasses.
 */
public class AI {

    /**
     * Determines the next valid card to play from the hand based on current card pile.
     * Iterates through the hand and returns the first card that can be legally played on
     * the top card of the card pile. If no valid card is found, returns null.
     * @param hand The hand of cards available for the AI to play.
     * @param cardPile The current card pile the AI needs to play on.
     * @return The first valid card that can be played, or null
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        // Iterate through each card in the hand
        for (int i = 0; i < hand.getSize(); ++i) {
            // Get the card at the current index
            Card card = hand.get(i);
            // If the card can be legally played on the current card pile, return it
            if (cardPile.canPlay(hand.get(i))) {
                return hand.get(i);
            }
        }
        // If no valid card is found, return null
        return null;
    }

    /**
     * Provides the name of this AI class.
     * This method is intended to return a string that identifies the AI type.
     * @return "Random Card AI".
     */
    @Override
    public String toString() {
        // Base class always returns this name
        return "Random Card AI";
    }
}
