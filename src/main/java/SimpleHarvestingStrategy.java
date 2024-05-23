import java.util.List;

public class SimpleHarvestingStrategy implements HarvestingStrategy {
    @Override
    public HarvestResult harvestBeans(Player player, int fieldIndex) {
        Field field = player.getFields().get(fieldIndex);
        List<Card> harvested = field.harvestBeans();
        int coins = harvested.size();  // Simplified calculation for example
        return new HarvestResult(coins, harvested);
    }
}