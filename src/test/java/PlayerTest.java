import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        player = new Player();
        // Populate the player's hand with some cards
        for (int i = 0; i < 5; i++) {
            player.addCardToHand(new Card("Bean" + i, 2));
        }
    }

    @Test
    public void testAddCardToHand() {
        player.addCardToHand(new Card("Black Bean", 2));
        assertEquals("Hand should have 6 cards", 6, player.getHand().size());
    }

    @Test
    public void testPlantBean() {
        player.plantBean(0, 0);
        assertEquals("First field should have 1 bean", 1, player.getFields().get(0).getNumberOfBeans());
    }

    @Test
    public void testBuyField() {
        // Give player enough coins to buy a field
        player.addCoins(3);
        assertTrue("Player should be able to buy a field", player.canBuyField());
        player.buyField();
        assertEquals("Player should have 3 fields", 3, player.getFields().size());
        assertEquals("Player coins should be zero after purchase", 0, player.getCoins());
    }

    @Test
    public void testCannotBuyFieldWithoutEnoughCoins() {
        // Ensure player does not have enough coins
        player.addCoins(2); // Less than required
        assertFalse("Player should not be able to buy a field", player.canBuyField());
    }
}
