import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Deck {
    private Stack<Card> drawDeck = new Stack<>();
    private List<Card> discardDeck = new LinkedList<>();
    private ShufflingStrategy shufflingStrategy;
    private int reshuffleCount = 0;

    public Deck(ShufflingStrategy strategy) {
        this.shufflingStrategy = strategy;
        initializeDeck();
    }

    private void initializeDeck() {
        // Populate the draw deck with initial cards
        for (int i = 0; i < 104; i++) {
            drawDeck.push(new Card("Bean" + (i % 10), i % 5 + 1));
        }
        shuffle();
    }

    public void shuffle() {
        if (!discardDeck.isEmpty()) {
            drawDeck.addAll(discardDeck);
            discardDeck.clear();
            shufflingStrategy.shuffle(drawDeck);
            reshuffleCount++;
            System.out.println("Discard deck reshuffled into the draw deck. Reshuffle count: " + reshuffleCount);
        } else {
            shufflingStrategy.shuffle(drawDeck);
        }
    }

    public Card draw() {
        if (drawDeck.isEmpty() && !discardDeck.isEmpty()) {
            shuffle();  // Reshuffle the discard deck back into the draw deck
        }
        return drawDeck.isEmpty() ? null : drawDeck.pop();
    }

    public void discard(Card card) {
        discardDeck.add(card);
    }

    public int getReshuffleCount() {
        return reshuffleCount;
    }

    public boolean isDrawDeckEmpty() {
        return drawDeck.isEmpty();
    }
}
