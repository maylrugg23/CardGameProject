package student;

/**
 * The SmallestCardAI class represents an AI that chooses the smallest valid card
 * to play based on the current card pile.
 * This AI will evaluate each card in the hand and return the smallest-ranked card
 * that can be legally played. If no valid card, it will return null.
 * It extends the AI class and overrides the getPlay and toString methods.
 */
public class SmallestCardAI extends AI {

    /**
     * Gets card from hand that AI chose to be played. In this AI,
     * the choice is the smallest rank possible.
     * @param hand of cards AI has to choose from.
     * @param cardPile object used to make decision.
     * @return AI's choice of card from hand to play, null if no possible card to play
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        // Variable to track the smallest valid card
        Card smallest = null;
        // Iterate over all cards in the hand
        for (int k = 0; k < hand.getSize(); ++k) {
            // If no smallest card has been found yet, check if the current card can be played
            if (smallest == null && cardPile.canPlay(hand.get(k))) {
                // Set the current card as the smallest if valid
                smallest = hand.get(k);
            }
            // If the current card can be played, check if it's smaller than the current smallest card
            if (cardPile.canPlay(hand.get(k))) {
                // Ensures that smallest is not null at this point
                assert smallest != null;
                if (hand.get(k).getRankNum() < smallest.getRankNum()) {
                    // Update smallest if a smaller valid card is found
                    smallest = hand.get(k);
                }
            }
        }
        // Return the smallest valid card, or null if no valid card was found
        return smallest;
    }

    /**
     * Name of AI.
     * @return "Smallest Card AI".
     */
    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
