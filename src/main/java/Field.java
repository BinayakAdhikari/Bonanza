import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Card> cards = new ArrayList<>();

    public void plantBean(Card card) {
        cards.add(card);
    }

    public List<Card> harvestBeans() {
        List<Card> harvested = new ArrayList<>(cards);
        cards.clear();
        return harvested;
    }

    public int getNumberOfBeans() {
        return cards.size();
    }
}
