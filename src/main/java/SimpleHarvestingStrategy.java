import java.util.ArrayList;
import java.util.List;

public class SimpleHarvestingStrategy implements HarvestingStrategy {
    @Override
    public HarvestResult harvest(Field field, Player player) {
        int beanCount = field.getBeans().size();
        if (beanCount == 0) {
            return new HarvestResult(0, new ArrayList<>());
        }
        BeanType beanType = field.getBeans().get(0).getBeanType();
        int coins = beanType.getBeanometer().getHarvestValue(beanCount);
        List<Card> harvestedCards = new ArrayList<>(field.getBeans());
        field.clear();

        System.out.println("[" + player.getName() + "] harvests " + beanCount + " " + beanType.getName() + "(s) and gains " + coins + " coins.");
        return new HarvestResult(coins, harvestedCards);
    }
}
