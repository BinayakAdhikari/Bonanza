import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Card> tradingArea = new ArrayList<>();
    TradingStrategy tradingStrategy = new SimpleTradingStrategy();

    // Adds a card to the trading area
    public void addCard(Card card) {
        tradingArea.add(card);
    }

    // Trades a card between two players if the card exists in the trading area
    public boolean tradeCard(Player giver, Player receiver, Card card) {
        return tradingStrategy.tradeCard(giver, receiver, card);
    }

    // Gets all cards in the trading area
    public List<Card> getTradingCards() {
        return tradingArea;
    }
}
