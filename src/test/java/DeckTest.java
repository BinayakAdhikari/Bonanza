import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    @Test
    public void testDeck() {
        Beanometer beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        BeanType beanType = new BeanType("Blue Bean", beanometer);
        List<Card> cards = Arrays.asList(new Card(beanType), new Card(beanType));
        ShufflingStrategy shufflingStrategy = new RandomShuffleStrategy();

        Deck deck = new Deck(cards, shufflingStrategy);
        assertFalse(deck.isEmpty());

        Card drawnCard = deck.drawCard();
        assertNotNull(drawnCard);

        deck.discardCard(drawnCard);
        deck.reshuffleDiscardIntoDraw();
        assertFalse(deck.isEmpty());
    }
}
