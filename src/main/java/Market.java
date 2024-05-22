import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Card> tradingArea = new ArrayList<>();

    // Adds a card to the trading area
    public void addCard(Card card) {
        tradingArea.add(card);
    }

    // Trades a card between two players if the card exists in the trading area
    public boolean tradeCard(Player giver, Player receiver, Card card) {
        if (tradingArea.contains(card)) {
            tradingArea.remove(card);
            giver.getHand().remove(card);
            receiver.addCardToHand(card);
            return true; // Trade successful
        }
        return false; // Trade failed
    }

    // Gets all cards in the trading area
    public List<Card> getTradingCards() {
        return tradingArea;
    }
}
