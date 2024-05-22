import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    // Test initialization of Card with proper attributes
    @Test
    public void testCardInitialization() {
        Card card = new Card("Blue Bean", 4);

        // Validate that the card attributes are initialized correctly
        assertEquals("Blue Bean", card.getBeanType(), "Bean type should be 'Blue Bean'");
        assertEquals(4, card.getBeanometer(), "Bean-o-meter should be 4");
    }
}
