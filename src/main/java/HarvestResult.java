import java.util.List;

public class HarvestResult {
    private int coins;
    private List<Card> harvestedCards;

    public HarvestResult(int coins, List<Card> harvestedCards) {
        this.coins = coins;
        this.harvestedCards = harvestedCards;
    }

    public int getCoins() {
        return coins;
    }

    public List<Card> getHarvestedCards() {
        return harvestedCards;
    }
}
