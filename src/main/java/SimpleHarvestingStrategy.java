import java.util.List;

public class SimpleHarvestingStrategy implements HarvestingStrategy {
    @Override
    public int harvestBeans(Player player, int fieldIndex) {
        Field field = player.getFields().get(fieldIndex);
        List<Card> harvested = field.harvestBeans();
        int coins = harvested.size() / 2;  // Simplify coin calculation for example
        player.addCoins(coins);
        return coins;
    }
}
