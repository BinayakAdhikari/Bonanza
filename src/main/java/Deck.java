import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards = new Stack<>();

    // Constructor to initialize the deck with cards
    public Deck() {
        // Example initialization with simplified card creation
        for (int i = 0; i < 104; i++) {
            cards.push(new Card("Bean" + (i % 10), i % 5 + 1));
        }
        shuffle();
    }

    // Method to shuffle the cards in the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw a card from the deck
    public Card draw() {
        return cards.isEmpty() ? null : cards.pop();
    }

    // Method to get the current number of cards in the deck
    public int getSize() {
        return cards.size();
    }
}
