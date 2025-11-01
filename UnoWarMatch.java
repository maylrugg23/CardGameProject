package student;

/**
 * Represents a match of Uno War between two AI players.
 * Uno War is a game played over multiple rounds, where each player attempts to play a valid card.
 * A round is won by the player who can play a card when the other player cannot.
 * The match continues until one player wins 10 rounds, making them the overall game winner.
 * The class manages each player’s hands, deck, turn order, and win tracking, as well as the
 * mechanics for determining the winner of each round and the overall match.
 */
public class UnoWarMatch {

    /**
     * AI player 1 instance.
     */
    private final AI ai1;

    /**
     * AI player 2 instance.
     */
    private final AI ai2;

    /**
     * Number of wins for player 1.
     */
    private int numWins1;

    /**
     * Number of wins for player 2.
     */
    private int numWins2;

    /**
     * Current round number.
     */
    private int round;

    /**
     * Hand of cards for player 1.
     */
    private Hand hand1;

    /**
     * Hand of cards for player 2.
     */
    private Hand hand2;

    /**
     * Deck being used in game.
     */
    private Deck deck;

    /**
     * Card pile within game.
     */
    private CardPile cardPile;

    /**
     * Turn number between player 1 an 2.
     */
    private int turn;

    /**
     * Player 1's choice of card to play.
     */
    private Card choice1;

    /**
     * Player 2's choice of card to play.
     */
    private Card choice2;

    /**
     * Initializes a new UnoWarMatch with two AI players.
     * @param ai1 AI for player 1.
     * @param ai2 AI for player 2.
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
        this.numWins1 = 0;
        this.numWins2 = 0;
        this.round = 1;
    }

    /**
     * Plays a single Uno War game between the two AIs.
     * The game is played over multiple rounds, where each round is won by the player who can play a valid card
     * when the other player cannot. The game continues until one AI wins 10 rounds.
     * @return true if player 1 wins or false if player 2 wins.
     */
    public boolean playGame() {
        deck = new Deck();
        hand1 = new Hand(deck, 5);
        hand2 = new Hand(deck, 5);
        numWins1 = 0;
        numWins2 = 0;
        turn = 0;
        round = 1;

        // Continue playing until one player wins 10 rounds
        while (numWins1 < 10 && numWins2 < 10) {
            turn = getBeginningTurn();
            cardPile = new CardPile(deck.draw());
            choice1 = new Card(1, 1);
            choice2 = new Card(1, 1);

            // Continue until the current round has a winner
            while (getWinner() == 0) {
                // Player 1's turn
                if (turn == 1) {
                    choice1 = ai1.getPlay(hand1, cardPile);
                    if (choice1 != null) {
                        cardPile.play(choice1);
                        hand1.remove(choice1);
                        // Switch to player 2's turn
                        turn = 2;
                    }
                }

                // Player 2's turn
                if (turn == 2) {
                    choice2 = ai2.getPlay(hand2, cardPile);
                    if (choice2 != null) {
                        cardPile.play(choice2);
                        hand2.remove(choice2);
                        // Switch to player 1's turn
                        turn = 1;
                    }
                }
            }

            // After the round, check who won and update the win count
            int winner = getWinner();
            if (winner == 1) {
                numWins1++;
            } else if (winner == 2) {
                numWins2++;
            }

            round++;
        }

        // Return true if player 1 wins 10 rounds, false if player 2 wins
        return numWins1 == 10;
    }

    /**
     * Calculates the win rate of player 1 over multiple Uno War game trials.
     * @param nTrials the number of games to simulate.
     * @return the win rate of player 1 as a double value between 0 and 1, as
     * the fraction of games won by player 1 out of nTrials games.
     */
    public double winRate(int nTrials) {
        int ai1Wins = 0;
        double winRate = 0.0;
        for (int i = 0; i < nTrials; ++i) {
            boolean winner = playGame();
            if (winner) {
                ai1Wins++;
            }
        }
        winRate = ai1Wins / (double) nTrials;
        return winRate;
    }

    /**
     * Determines which player takes the first turn at the beginning of each round.
     * @return 1 if player 1's turn, 2 if player 2's turn, 0 as default.
     */
    public int getBeginningTurn() {
        if (round == 1) {
            return 1;
        }
        if (getWinner() == 2) {
            return 2;
        } else if (getWinner() == 1) {
            return 1;
        }
        return 0;
    }

    /**
     * Determine the winner of the current round.
     * @return 1 if player 1 wins, 2 if player 2 wins, 0 if neither wins.
     */
    public int getWinner() {
        if (turn == 1 && choice1 == null) {
            return 2;
        } else if (turn == 2 && choice2 == null) {
            return 1;
        } else {
            return 0;
        }
    }
}
