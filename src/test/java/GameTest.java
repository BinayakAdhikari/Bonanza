import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testGame() {
        Game game = new Game();
        game.setupGame();

        assertFalse(game.isGameOver());

        game.startGame();

        assertTrue(game.getPlayers().get(0).getHand().size() > 0);
    }
}
