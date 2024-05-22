import java.util.List;

public class SimpleHarvestingStrategy implements HarvestingStrategy {
    @Override
    public int harvestBeans(Player player, int fieldIndex) {
        Field field = player.getFields().get(fieldIndex);
        List<Card> harvested = field.harvestBeans();
        int coins = harvested.size();  // Simple coin calculation: 1 coin per bean
        player.addCoins(coins);
        return coins;
    }
}
