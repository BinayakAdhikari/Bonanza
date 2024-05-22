import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Card> cards = new ArrayList<>();

    // Adds a card to this field
    public void plantBean(Card card) {
        cards.add(card);
    }

    // Harvests all cards from this field and returns them
    public List<Card> harvestBeans() {
        List<Card> harvested = new ArrayList<>(cards);
        cards.clear();
        return harvested;
    }

    // Returns the current number of beans in the field
    public int getNumberOfBeans() {
        return cards.size();
    }

    // Provides access to the cards currently in the field
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}
