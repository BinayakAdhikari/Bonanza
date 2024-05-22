import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards = new Stack<>();

    public Deck() {
        for (int i = 0; i < 104; i++) {
            cards.push(new Card("Bean" + (i % 10), i % 5 + 1));
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.isEmpty() ? null : cards.pop();
    }
}
