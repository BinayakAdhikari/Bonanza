import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(2); // Simple game setup for 2 players for testing
    }

    @Test
    void testPlayTurn() {
        Player player = game.getPlayers().get(0);
        player.addCardToHand(new Card("Green Bean", 2));
        game.playTurn(player);
        assertFalse(player.getHand().isEmpty(), "Player should have cards in hand after drawing.");
        assertEquals(3, player.getHand().size(), "Player should have drawn 3 cards.");
    }

    @Test
    void testGameEndCondition() {
        Player player = game.getPlayers().get(0);
        player.addCardToHand(new Card("Green Bean", 2));
        while (!game.isGameOver()) {
            game.playTurn(player);
        }
        assertTrue(game.isGameOver(), "Game should end when the deck is exhausted.");
    }
}
