import java.util.ArrayList;
import java.util.List;

public class Market {
    // Holds cards available for trading
    private List<Card> turnOverCard;

    // Holds player who participated in trade
    private List<Player> traders;

    // Constructor initializes an empty trading area
    public Market() {
        turnOverCard = new ArrayList<>();
    }

    // Add cards to the trading area
    public void addCards(List<Card> cards) {
        turnOverCard.addAll(cards);
    }

    // Allow players to trade cards directly in the market
    public boolean trade(Player playerGiving, Player playerReceiving, Card cardToTrade) {
        // Check if the player actually has the card to trade
        if (turnOverCard.contains(cardToTrade)) {
            // Remove the card from the market and add it to the receiving player
            turnOverCard.remove(cardToTrade);
            playerReceiving.addCardToHand(cardToTrade);

            // The player giving removes it from their hand (for simplicity, remove by object)
            playerGiving.getHand().remove(cardToTrade);
            return true; // Successful trade
        }
        return false; // Trade failed
    }

    // Return the list of cards currently in the trading area
    public List<Card> getTurnover() {
        return turnOverCard;
    }
}
