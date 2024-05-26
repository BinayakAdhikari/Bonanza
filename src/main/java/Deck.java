import java.util.*;

public class Deck {
    private List<Card> drawPile;
    private List<Card> discardPile;
    private ShufflingStrategy shufflingStrategy;

    public Deck(List<Card> cards, ShufflingStrategy shufflingStrategy) {
        this.drawPile = new ArrayList<>(cards);
        this.discardPile = new ArrayList<>();
        this.shufflingStrategy = shufflingStrategy;
        shuffle();
    }

    public void shuffle() {
        shufflingStrategy.shuffle(drawPile);
    }

    public Card drawCard() {
        if (drawPile.isEmpty()) {
            reshuffleDiscardIntoDraw();
        }
        if (drawPile.isEmpty()) {
            return null; // No cards left to draw
        }
        return drawPile.remove(0);
    }

    public void discardCard(Card card) {
        discardPile.add(card);
    }

    public void reshuffleDiscardIntoDraw() {
        drawPile.addAll(discardPile);
        discardPile.clear();
        shuffle();
    }

    public boolean isEmpty() {
        return drawPile.isEmpty() && discardPile.isEmpty();
    }
}
