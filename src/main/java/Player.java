import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();
    private int coins = 0;
    private String name;  // Player name for better identification
    private PlantingStrategy plantingStrategy;
    private HarvestingStrategy harvestingStrategy;

    public Player(String name, PlantingStrategy plantingStrategy, HarvestingStrategy harvestingStrategy) {
        this.name = name;
        fields.add(new Field());  // Initialize with two fields
        fields.add(new Field());
        this.plantingStrategy = plantingStrategy;
        this.harvestingStrategy = harvestingStrategy;
    }

    public void plantBean(Card card, int fieldIndex) {
        plantingStrategy.plantBean(this, card, fieldIndex);
        System.out.println(name + " plants " + card.getBeanType() + " in field " + fieldIndex);
    }

    public int harvestBeans(int fieldIndex) {
        int coinsEarned = harvestingStrategy.harvestBeans(this, fieldIndex);
        System.out.println(name + " harvests field " + fieldIndex + " for " + coinsEarned + " coins");
        return coinsEarned;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
        System.out.println(name + " receives card " + card.getBeanType());
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Field> getFields() {
        return fields;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + '}';
    }
}
