import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Card> plantedBeans;

    public Field() {
        this.plantedBeans = new ArrayList<>();
    }

    public void addBean(Card card) {
        plantedBeans.add(card);
    }

    public HarvestResult harvestField() {
        if (plantedBeans.isEmpty()) return new HarvestResult(0, new ArrayList<>());
        BeanType beanType = plantedBeans.get(0).getBeanType();
        int coinCount = beanType.getBeanometer().getHarvestValue(plantedBeans.size());
        List<Card> harvestedCards = new ArrayList<>(plantedBeans);
        plantedBeans.clear();
        return new HarvestResult(coinCount, harvestedCards);
    }

    public boolean canPlant(Card card) {
        if (plantedBeans.isEmpty()) return true;
        return plantedBeans.get(0).getBeanType().equals(card.getBeanType());
    }

    public String getStatus() {
        if (plantedBeans.isEmpty()) return "Empty field";
        return plantedBeans.size() + " " + plantedBeans.get(0).getBeanType().getName() + "(s)";
    }
}
