import java.util.ArrayList;
import java.util.List;

public interface TradingStrategy {
    List<Card> tradingArea = new ArrayList<>();
    boolean tradeCard(Player giver, Player receiver, Card card);
}
