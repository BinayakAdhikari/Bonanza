import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;
    private Card card;

    @BeforeEach
    void setUp() {
        player = new Player(new SimplePlantingStrategy(), new SimpleHarvestingStrategy());
        card = new Card("Black Bean", 5);
        player.addCardToHand(card);
    }

    @Test
    void testPlantBean() {
        player.plantBean(card, 0);
        assertEquals(1, player.getFields().get(0).getNumberOfBeans(), "Field should have one bean after planting.");
    }

    @Test
    void testHarvestBeans() {
        player.plantBean(card, 0);
        int coinsEarned = player.harvestBeans(0);
        assertEquals(0, player.getFields().get(0).getNumberOfBeans(), "Field should be empty after harvesting.");
        assertTrue(coinsEarned > 0, "Player should earn coins from harvesting.");
    }
}
