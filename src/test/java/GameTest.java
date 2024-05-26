import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testGame() {
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        List<Player> players = Arrays.asList(new Player("Alice", plantingStrategy, harvestingStrategy), new Player("Bob", plantingStrategy, harvestingStrategy));

        Beanometer beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        BeanType beanType = new BeanType("Blue Bean", beanometer);
        List<Card> cards = Arrays.asList(new Card(beanType), new Card(beanType), new Card(beanType), new Card(beanType), new Card(beanType));

        ShufflingStrategy shufflingStrategy = new RandomShuffleStrategy();
        Game game = new Game(players, cards, shufflingStrategy);

        assertFalse(game.isGameOver());

        game.startGame();

        assertTrue(game.getPlayers().get(0).getHand().size() > 0);
    }
}
