import java.util.ArrayList;
import java.util.List;

public class SimpleHarvestingStrategy implements HarvestingStrategy {
    @Override
    public HarvestResult harvest(Field field, Player player) {
        List<Card> beans = field.getBeans();
        int beanCount = beans.size();

        if (beanCount == 0) {
            return new HarvestResult(0, new ArrayList<>());
        }

        BeanType beanType = beans.get(0).getBeanType();
        int coins = beanType.getBeanometer().getHarvestValue(beanCount);
        List<Card> harvestedCards = new ArrayList<>(beans);
        field.clear();

        System.out.println("[" + player.getName() + "] harvests " + beanCount + " " + beanType.getName() + "(s) and gains " + coins + " coin(s).");
        return new HarvestResult(coins, harvestedCards);
    }
}
