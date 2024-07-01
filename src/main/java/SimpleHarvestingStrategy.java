import java.util.ArrayList;
import java.util.List;

public class SimpleHarvestingStrategy implements HarvestingStrategy {
    @Override
    public HarvestResult harvest(Field field, Player player) {
        List<Card> beans = field.getBeans();
        int numBeans = beans.size();
        int coinsEarned = calculateCoins(numBeans);
        List<Card> harvestedCards = new ArrayList<>(beans.subList(0, numBeans));
        field.clear();
        return new HarvestResult(coinsEarned, harvestedCards);
    }

    @Override
    public void harvest(BeanMafiaBoss boss, Deck deck) {

    }

    private int calculateCoins(int numBeans) {
        if (numBeans >= 8) return 4;
        if (numBeans >= 7) return 3;
        if (numBeans >= 5) return 2;
        if (numBeans >= 3) return 1;
        return 0;
    }
}
