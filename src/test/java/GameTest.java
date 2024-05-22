import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        // Set up the game with a specific number of players, for example, 4 players.
        game = new Game(4);
    }

    @Test
    void testMultiplePlayerTurns() {
        // Simulate a full round of turns for all players
        for (Player player : game.getPlayers()) {
            int initialHandSize = player.getHand().size();
            game.playTurn(player);
            // Test that each player draws three cards at the end of their turn
            assertEquals(initialHandSize + 3, player.getHand().size(), "Player should have three more cards after their turn.");
        }
    }

    @Test
    void testGameProgression() {
        int rounds = 5;  // Number of rounds to simulate
        for (int i = 0; i < rounds; i++) {
            for (Player player : game.getPlayers()) {
                game.playTurn(player);
            }
        }
        // Test to check if the game progresses correctly over several rounds
        assertTrue(game.getPlayers().get(0).getHand().size() > 0, "Players should have cards after multiple rounds.");
        assertFalse(game.isGameOver(), "Game should not be over too quickly.");
    }

    @Test
    void testGameEndCondition() {
        // Continuously play turns until the game ends
        while (!game.isGameOver()) {
            for (Player player : game.getPlayers()) {
                game.playTurn(player);
            }
        }
        assertTrue(game.isGameOver(), "Game should end when the deck is exhausted.");
    }
}
