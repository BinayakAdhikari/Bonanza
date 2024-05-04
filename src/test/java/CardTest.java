
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CardTest {
    @Test
    public void testCardInitialization() {
        Card card = new Card("Blue Bean", 4);
        assertEquals("Blue Bean", "Blue Bean", card.getBeanType());
        assertEquals(4, 4, card.getBeanometer());
    }
}
