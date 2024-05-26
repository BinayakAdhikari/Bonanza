import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayer() {
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        Player player = new Player("Alice", plantingStrategy, harvestingStrategy);

        assertEquals("Alice", player.getName());
        assertTrue(player.getHand().isEmpty());
        assertEquals(2, player.getFields().size());

        Beanometer beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        BeanType beanType = new BeanType("Blue Bean", beanometer);
        Card card = new Card(beanType);

        player.getHand().add(card);
        player.plantBeanFromHand();

        assertTrue(player.getHand().isEmpty());
        assertEquals(1, player.getFields().get(0).getStatus().split(" ").length);
    }
}
