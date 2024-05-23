import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck(new RandomShuffleStrategy());  // Initialize the deck before each test
    }

    @Test
    void testDrawCard() {
        Card card = deck.draw();
        assertNotNull(card, "Drawn card should not be null when the deck is initialized correctly.");
    }

    @Test
    void testDeckSizeAfterDraw() {
        int initialSize = deck.getSize();  // Assuming getSize() correctly returns the number of cards in the deck
        deck.draw();
        assertEquals(initialSize - 1, deck.getSize(), "Deck size should decrease by 1 after a card is drawn.");
    }

    @Test
    void testShuffleDeck() {
        Card firstCard = deck.draw();
        deck.shuffle(); // Assuming shuffle is properly randomizing the deck
        deck = new Deck(new RandomShuffleStrategy()); // Reinitialize to reset the deck
        deck.shuffle();
        assertNotEquals(firstCard, deck.draw(), "First card should not be the same after reshuffling.");
    }
}
