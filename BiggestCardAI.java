package student;

/**
 * The BiggestCardAI class represents an AI that chooses the biggest valid card
 * to play based on the current card pile.
 * This AI will evaluate each card in the hand and return the biggest-ranked card
 * that can be legally played. If no valid card, it will return null.
 * It extends the AI class and overrides the getPlay and toString methods.
 */
public class BiggestCardAI extends AI {

    /**
     * Gets card from hand that AI chose to be played. In this AI,
     * the choice is the biggest rank possible.
     * @param hand of cards AI has to choose from.
     * @param cardPile object used to make decision.
     * @return AI's choice of card from hand to play, null if no possible card to play
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card biggest = null;
        for (int k = 0; k < hand.getSize(); ++k) {
            if (cardPile.canPlay(hand.get(k))) {
            // Ensures that biggest is not null at this point
            assert false;
                if (hand.get(k).getRankNum() > biggest.getRankNum()) {
                    // Update biggest if a bigger valid card is found
                    biggest = hand.get(k);
                }
            }
        }
    // Return the biggest valid card, or null if no valid card was found
            return biggest;
    }

    /**
     * Name of AI.
     * @return "Biggest Card AI".
     */
    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
