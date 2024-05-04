import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game(4);  // Initialize the game with 4 players
    }

    @Test
    public void testGameInitialization() {
        assertEquals("Game should have 4 players", 4, game.getPlayers().size());
        assertNotNull("Deck should be initialized", game.getDeck());
    }

    @Test
    public void testPlayTurn() {
        Player currentPlayer = game.getPlayers().get(0);
        int initialHandSize = currentPlayer.getHand().size();
        game.playTurn(currentPlayer);
        // Assuming each player starts with 5 cards and plays 1 bean to the first field
        assertEquals("Player should have 1 fewer card in hand after planting", initialHandSize - 1, currentPlayer.getHand().size());
    }

    @Test
    public void testGameEndCondition() {
        while (game.getDeck().getSize() > 0) {
            for (Player player : game.getPlayers()) {
                game.playTurn(player);
                if (game.getDeck().getSize() == 0) {
                    break;
                }
            }
        }
        assertTrue("Game should be over when the deck is empty", game.isGameOver());
    }
}
