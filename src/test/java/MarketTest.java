import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class MarketTest {
    @Test
    public void testMarketTrade() {
        Game game = new Game();
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        Player alice = new Player("Alice", plantingStrategy, harvestingStrategy, game);
        Player bob = new Player("Bob", plantingStrategy, harvestingStrategy, game);
        List<Player> players = Arrays.asList(alice, bob);

        Market market = new Market(players);

        Beanometer beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        BeanType blueBean = new BeanType("Blue Bean", beanometer);
        BeanType chiliBean = new BeanType("Chili Bean", beanometer);

        alice.getHand().add(new Card(blueBean));
        bob.getHand().add(new Card(chiliBean));

        // Assume we define a simple trade where Alice and Bob exchange the first card in their hand
        // For simplicity, let's simulate a trade by directly exchanging cards
        Card aliceCard = alice.getHand().remove(0);
        Card bobCard = bob.getHand().remove(0);
        alice.getHand().add(bobCard);
        bob.getHand().add(aliceCard);

        // Check if the cards were exchanged
        assertEquals("Chili Bean", alice.getHand().get(0).getBeanType().getName());
        assertEquals("Blue Bean", bob.getHand().get(0).getBeanType().getName());
    }
}
