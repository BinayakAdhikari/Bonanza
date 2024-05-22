import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;
    private Card card;

    @BeforeEach
    void setUp() {
        // Assume each card represents a significant value for simplification
        player = new Player("Player 1", new SimplePlantingStrategy(), new SimpleHarvestingStrategy());
        card = new Card("Black Bean", 5);
        player.addCardToHand(card);
//        player.plantBean(card, 0);  // Plant the card in the field
    }

    @Test
    void testPlantBean() {
        player.plantBean(card, 0);
        assertEquals(1, player.getFields().get(0).getCards().size(), "Field should have one bean after planting.");
        assertTrue(player.getFields().get(0).getCards().contains(card), "The planted card should be in the field.");
    }

    @Test
    void testHarvestBeans() {
        int coinsBefore = player.getCoins();
        int coinsEarned = player.harvestBeans(0);
        assertTrue(coinsEarned > 0, "Player should earn coins from harvesting.");
        assertTrue(player.getCoins() > coinsBefore, "Player's coin total should increase after harvesting.");
        assertEquals(0, player.getFields().get(0).getNumberOfBeans(), "Field should be empty after harvesting.");
    }
}
