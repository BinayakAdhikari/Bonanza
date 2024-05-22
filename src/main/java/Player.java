import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();
    private int coins = 0;
    private PlantingStrategy plantingStrategy;
    private HarvestingStrategy harvestingStrategy;

    public Player(PlantingStrategy plantingStrategy, HarvestingStrategy harvestingStrategy) {
        fields.add(new Field());  // Initialize with two fields
        fields.add(new Field());
        this.plantingStrategy = plantingStrategy;
        this.harvestingStrategy = harvestingStrategy;
    }

    public void plantBean(Card card, int fieldIndex) {
        plantingStrategy.plantBean(this, card, fieldIndex);
    }

    public int harvestBeans(int fieldIndex) {
        return harvestingStrategy.harvestBeans(this, fieldIndex);
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }
}
