import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(2); // Simple game with 2 players for testing
    }

    @Test
    void testPlayTurn() {
        Player player = game.getPlayers().get(0);
        player.addCardToHand(new Card("Green Bean", 2));
        game.playTurn(player);
        assertNotNull(player.getHand(), "Player should have cards in hand after drawing.");
    }

    @Test
    void testGameEndCondition() {
        game.getPlayers().forEach(p -> p.addCardToHand(new Card("Green Bean", 2)));
        while (!game.isGameOver()) {
            game.playTurn(game.getPlayers().get(0));
        }
        assertTrue(game.isGameOver(), "Game should end when the deck is exhausted.");
    }
}
