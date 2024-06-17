import java.util.*;

public class Deck {
    private List<Card> drawPile;
    private List<Card> discardPile;
    private ShufflingStrategy shufflingStrategy;
    private Game game;

    public Deck(List<Card> cards, ShufflingStrategy shufflingStrategy, Game game) {
        this.drawPile = new ArrayList<>(cards);
        this.discardPile = new ArrayList<>();
        this.shufflingStrategy = shufflingStrategy;
        this.game = game;
        shuffle();
    }

    public void shuffle() {
        shufflingStrategy.shuffle(drawPile);
    }

    public Card draw() {
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
        if (discardPile.isEmpty()) {
            return; // Nothing to reshuffle
        }
        drawPile.addAll(discardPile);
        discardPile.clear();
        shuffle();
        game.incrementReshuffleCount();
        System.out.println("Reshuffled the discard pile into the draw pile. Total reshuffles: " + game.getDrawPileReshuffles());
    }

    public boolean isEmpty() {
        return drawPile.isEmpty() && discardPile.isEmpty();
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }
}
