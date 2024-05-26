import java.util.Map;

public class Beanometer {
    private Map<Integer, Integer> harvestValue;

    public Beanometer(Map<Integer, Integer> harvestValue) {
        this.harvestValue = harvestValue;
    }

    public int getHarvestValue(int count) {
        return harvestValue.getOrDefault(count, 0);
    }
}
