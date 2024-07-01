import java.util.ArrayList;
import java.util.List;

public class BeanMafiaBoss {
    private String name;
    private List<Card> field;
    private int harvestThreshold;
    private int coins;

    public BeanMafiaBoss(String name, int harvestThreshold) {
        this.name = name;
        this.field = new ArrayList<>();
        this.harvestThreshold = harvestThreshold;
        this.coins = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getField() {
        return field;
    }

    public int getHarvestThreshold() {
        return harvestThreshold;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void plantBean(Card card) {
        field.add(card);
        System.out.println("MAFIA [" + name + "] receives " + card.getBeanType().getName() + ". Field size now: " + field.size());
    }

    public boolean shouldHarvest() {
        return field.size() >= harvestThreshold;
    }

    public int calculateCoins(int numBeans) {
        if (numBeans >= 8) return 4;
        if (numBeans >= 7) return 3;
        if (numBeans >= 5) return 2;
        if (numBeans >= 3) return 1;
        return 0;
    }

    public void clearField() {
        field.clear();
    }

}
