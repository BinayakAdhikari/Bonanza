public class SimpleTradingStrategy implements TradingStrategy{
    public boolean tradeCard(Player giver, Player receiver, Card card) {
        if (tradingArea.contains(card)) {
            tradingArea.remove(card);
            giver.getHand().remove(card);
            receiver.addCardToHand(card);
            return true; // Trade successful
        }
        return false; // Trade failed
    }
}
