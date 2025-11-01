package student;

/**
 * Tournament class to simulate Uno War games between different AI players and
 * print the win rates of each matchup.
 */
public class Tournament {

    /**
     * Main method to initialize AIs and simulate matches, printing the win rate
     * for each pair of AIs.
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        int nTrials = 3000; // Number of trials for each matchup to get a reliable win rate

        // Instantiate AI instances
        AI randomAI = new AI();
        SmallestCardAI smallestAI = new SmallestCardAI();
        BiggestCardAI biggestAI = new BiggestCardAI();

        // Define match pairs with labels and AI instances
        Object[][] matchups = {
                {"Random Card AI", randomAI, "Random Card AI", randomAI },
                {"Random Card AI", randomAI, "Smallest Card AI", smallestAI },
                {"Random Card AI", randomAI, "Biggest Card AI", biggestAI },
                {"Smallest Card AI", smallestAI, "Random Card AI", randomAI },
                {"Smallest Card AI", smallestAI, "Smallest Card AI", smallestAI },
                {"Smallest Card AI", smallestAI, "Biggest Card AI", biggestAI },
                {"Biggest Card AI", biggestAI, "Random Card AI", randomAI },
                {"Biggest Card AI", biggestAI, "Smallest Card AI", smallestAI },
                {"Biggest Card AI", biggestAI, "Biggest Card AI", biggestAI }
        };

        // Loop through each matchup, play the games, and display win rates
        for (Object[] matchup : matchups) {
            String ai1Name = (String) matchup[0]; // Name for AI 1
            AI ai1 = (AI) matchup[1];             // AI 1 instance
            String ai2Name = (String) matchup[2]; // Name for AI 2
            AI ai2 = (AI) matchup[3];             // AI 2 instance

            // Create a new UnoWarMatch for the current AI matchup
            UnoWarMatch match = new UnoWarMatch(ai1, ai2);
            double winRate = match.winRate(nTrials); // Calculate win rate for AI 1 as player 1

            // Print the win rate for AI 1 vs AI 2
            System.out.printf("%s vs. %s winRate: %.3f%n", ai1Name, ai2Name, winRate);

            // If the AIs are different, print the reverse matchup (AI 2 vs AI 1)
            if (!ai1Name.equals(ai2Name)) {
                System.out.printf("%s vs. %s winRate: %.3f%n", ai2Name, ai1Name, 1 - winRate);
            }
        }
    }
}
