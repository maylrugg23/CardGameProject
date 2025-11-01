package student;

/**
 * The CardPile class represents a pile of cards in a card game.
 * It tracks the top card in the pile and provides methods to interact with it.
 * Methods allow checking if a card can be played, playing a card by replacing the top card,
 * getting the number of cards in the pile, and retrieving the current top card.
 * The pile only keeps track of the top card and the number of cards played so far.
 */
public class CardPile {

    /**
     * Top card of the card pile.
     */
    private Card topCard;

    /**
     * Track the size of the card pile.
     */
    private int size;

    /**
     * Constructor to initialize the card pile with given top card.
     * @param topCard card chosen to be the top card.
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.size = 1;
    }

    /**
     * Determines if card could be played based on the top card.
     * @param card being determined if able to play.
     * @return true if card can be played, false if unable
     */
    public boolean canPlay(Card card) {
        // If the card is null, it can't be played
        if (card == null) {
            return false;
        }
        // Check if the card's rank is greater than or equal to the top card's rank,
        // or if the card has the same suit as the top card
        boolean isRankValid = card.getRankNum() >= topCard.getRankNum();
        boolean isSuitValid = card.getSuitName().equals(topCard.getSuitName());

        return !(isRankValid == false && isSuitValid == false);
    }

    /**
     * Plays card by placing it on top of pile.
     * If not legal to play, it prints an error statement.
     * @param card to be played.
     */
    public void play(Card card) {
        if (canPlay(card)) {
            size += 1;
            topCard = card;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * Gets number of cards in card pile.
     * @return number of cards in the pile.
     */
    public int getNumCards() {
        return size;
    }

    /**
     * Gets top card of card pile.
     * @return top card.
     */
    public Card getTopCard() {
        return topCard;
    }
}

