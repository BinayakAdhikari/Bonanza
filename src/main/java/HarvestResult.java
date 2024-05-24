import java.util.List;

public class HarvestResult {
    private int coinsEarned;
    private List<Card> harvestedCards;

    public HarvestResult(int coinsEarned, List<Card> harvestedCards) {
        this.coinsEarned = coinsEarned;
        this.harvestedCards = harvestedCards;
    }

    public int getCoinsEarned() {
        return coinsEarned;
    }

    public List<Card> getHarvestedCards() {
        return harvestedCards;
    }
}