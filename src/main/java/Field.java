import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Card> beans;

    public Field() {
        this.beans = new ArrayList<>();
    }

    public boolean canPlant(Card card) {
        return beans.isEmpty() || beans.get(0).getBeanType().equals(card.getBeanType());
    }

    public void addBean(Card card) {
        beans.add(card);
    }

    public HarvestResult harvestField() {
        int beanCount = beans.size();
        BeanType beanType = beans.get(0).getBeanType();
        int coins = beanType.getBeanometer().getHarvestValue(beanCount);

        List<Card> harvestedCards = new ArrayList<>(beans);
        beans.clear();

        return new HarvestResult(coins, harvestedCards);
    }

    public String getStatus() {
        if (beans.isEmpty()) {
            return "Empty field";
        }
        BeanType beanType = beans.get(0).getBeanType();
        return beans.size() + " " + beanType.getName() + "(s)";
    }
}
