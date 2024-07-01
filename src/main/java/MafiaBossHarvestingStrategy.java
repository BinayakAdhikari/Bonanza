import java.util.ArrayList;
import java.util.List;

public class MafiaBossHarvestingStrategy implements HarvestingStrategy{

    @Override
    public HarvestResult harvest(Field field, Player player) {
        return null;
    }

    @Override
    public void harvest(BeanMafiaBoss boss, Deck deck) {
        harvestMafia(boss, deck.getDiscardPile());

    }

    public void harvestMafia(BeanMafiaBoss boss, List<Card> discardPile) {
        System.out.println("MAFIA [" + boss.getName() + "] checking if should harvest. Current field size: " + boss.getField().size() + ", threshold: " + boss.getHarvestThreshold());
        if (boss.shouldHarvest()) {
            int coinsEarned = boss.calculateCoins(boss.getField().size());
            boss.addCoins(coinsEarned);
            System.out.println("MAFIA [" + boss.getName() + "] harvests " + boss.getField().size() + " beans and earns " + coinsEarned + " coins. Total coins: " + boss.getCoins());
            discardPile.addAll(new ArrayList<>(boss.getField()));
            boss.clearField();
        } else {
            System.out.println("MAFIA [" + boss.getName() + "] does not meet the threshold for harvesting. Field size: " + boss.getField().size());
        }
    }
}
