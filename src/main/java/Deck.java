import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    private ShufflingStrategy shufflingStrategy;

    public Deck(ShufflingStrategy strategy) {
        this.shufflingStrategy = strategy;
        // Initialize deck with cards
        initializeDeck();
    }

    private void initializeDeck() {
        // Add cards to the deck
        for (int i = 0; i < 104; i++) {
            cards.add(new Card("Bean" + (i % 10), i % 5 + 1));
        }
        shuffle();
    }

    public void shuffle() {
        shufflingStrategy.shuffle(cards);
    }

    public Card draw() {
        return cards.isEmpty() ? null : cards.remove(0);
    }

    public int getSize() {
        return cards.size();
    }
}