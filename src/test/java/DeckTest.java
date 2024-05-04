import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class DeckTest {
    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();  // Assume the constructor fills the deck with cards
    }

    @Test
    public void testDeckInitialization() {
        assertEquals("Deck should initialize with 104 cards", 104, deck.getSize());
    }

    @Test
    public void testDrawCard() {
        int initialCount = deck.getSize();
        Card card = deck.draw();
        assertNotNull("Drawn card should not be null", card);
        assertEquals("Deck size should decrease by 1", initialCount - 1, deck.getSize());
    }

    @Test
    public void testShuffleDeck() {
        // Draw initial card order
        Card[] initialCards = new Card[5];
        for (int i = 0; i < 5; i++) {
            initialCards[i] = deck.draw();
        }

        // Shuffle the deck and redraw
        deck.shuffle();
        boolean isShuffled = false;

        for (int i = 0; i < 5; i++) {
            if (!initialCards[i].equals(deck.draw())) {
                isShuffled = true;
                break;
            }
        }

        assertTrue("Deck should be shuffled", isShuffled);
    }
}
