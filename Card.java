package student;

/**
 * This class represents a single playing card in a standard deck.
 * Each card has a rank (1-13) and a suit (1-4).
 * Ranks: 1 = Ace, 11 = Jack, 12 = Queen, 13 = King, and numbers in between represent numbered cards.
 * Suits: 1 = Spades, 2 = Hearts, 3 = Clubs, 4 = Diamonds.
 * The class has methods to get the card's rank and suit names,
 * then display the card as a string and check for equality between cards.
 */
public final class Card {

    /** The rank of a card in the game.
     * This field represents the card's numerical value, which could determine its strength
     * or order in comparison with other cards.
     */
    private final int rank;

    /**Represents the suit of the card (Spades, Hearts, Diamond, Clubs).
     *The suit is assigned as an integer value upon card creation.
     */
    private final int suit;

    /**
     * Constructor to create a card with specified rank and suit values.
     * If the rank or suit is out of valid range, it defaults to Ace of Spades and prints "Invalid Card".
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(int rank, int suit) {
        if (isValid(rank, suit)) {
            this.rank = rank;
            this.suit = suit;
        } else {
            System.out.println("Invalid Card");
            this.rank = 1; // Default to Ace
            this.suit = 1; // Default to Spades
        }
    }

    /**
     * Checks if the provided rank and suit values are within the valid range.
     * @param rank the rank of the card
     * @param suit the suit of the card
     * @return true if rank is between 1 and 13 and suit is between 1 and 4; false otherwise
     */
    private boolean isValid(int rank, int suit) {
        return rank >= 1 && rank <= 13 && suit >= 1 && suit <= 4;
    }

    /**
     * Returns the numeric rank of the card (1-13).
     * @return the rank of card
     */
    public int getRankNum() {
        return rank;
    }

    /**
     * Returns the name of the card's rank based on the rank value.
     * So 1 returns "Ace", 11 returns "Jack", and so forth
     * @return the rank name as a string
     */
    public String getRankName() {
        if (rank == 1) {
            return "Ace";
        } else if (rank == 2) {
            return "Two";
        } else if (rank == 3) {
            return "Three";
        } else if (rank == 4) {
            return "Four";
        } else if (rank == 5) {
            return "Five";
        } else if (rank == 6) {
            return "Six";
        } else if (rank == 7) {
            return "Seven";
        } else if (rank == 8) {
            return "Eight";
        } else if (rank == 9) {
            return "Nine";
        } else if (rank == 10) {
            return "Ten";
        } else if (rank == 11) {
            return "Jack";
        } else if (rank == 12) {
            return "Queen";
        } else if (rank == 13) {
            return "King";
        } else {
            return null;
        }
    }

    /**
     * Returns the name of the card's suit based on the suit value.
     * @return suit name as a string
     */
    public String getSuitName() {
        if (suit == 1) {
            return "Spades";
        } else if (suit == 2) {
            return "Hearts";
        } else if (suit == 3) {
            return "Clubs";
        } else {
            return "Diamonds";
        }
    }

    /**
     * Returns a string representation of the card.
     * Combines/Compares the rank and suit names.
     * @return card description as a string
     */
    @Override
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    /**
     * Checks if  card is equal to another by comparing rank and suit.
     * @param obj the object to compare with card
     * @return true if the other object is a Card with the same rank and suit, otherwise return false
     */
    @Override
    public boolean equals(Object obj) {
        // Check if both are the same object
        if (this == obj) {
            return true;
        }
        // Check type
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Compare rank and suit
        Card otherCard = (Card) obj;
        return rank == otherCard.rank && suit == otherCard.suit;
    }
}
