import java.util.HashMap;
import java.util.List;

public class SimpleHarvestingStrategy implements HarvestingStrategy {
    @Override
    public int harvestBeans(Player player, int fieldIndex) {
        Field field = player.getFields().get(fieldIndex);
        List<Card> harvested = field.harvestBeans();
        // get beanometer
        int numberOfCoins = harvested.size();
        int coins = harvested.get(0).getBeanometer(numberOfCoins);

        player.addCoins(coins);
        return coins;
    }
}
