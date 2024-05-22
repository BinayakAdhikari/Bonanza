import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    // Test initialization of Card with proper attributes
    @Test
    public void testCardInitialization() {
        Card card = new Card("Blue Bean", new HashMap<Integer,Integer>() {{
            put(4,1);
            put(6,2);
            put(8,3);
            put(9,4);
        }});

        // Validate that the card attributes are initialized correctly
        assertEquals("Blue Bean", card.getBeanType(), "Bean type should be 'Blue Bean'");
        assertEquals(1, card.getBeanometer(4), "Bean-o-meter should be 4");
    }
}
