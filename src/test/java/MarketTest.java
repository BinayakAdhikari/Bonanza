import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarketTest {
    private Market market;
    private Player player1;
    private Player player2;
    private Card card1;
    private Card card2;

    @BeforeEach
    void setUp() {
        market = new Market();
        // Including names and strategies for player instantiation
        player1 = new Player("Player 1", new SimplePlantingStrategy(), new SimpleHarvestingStrategy());
        player2 = new Player("Player 2", new SimplePlantingStrategy(), new SimpleHarvestingStrategy());
        card1 = new Card("Blue Bean", 4);
        card2 = new Card("Red Bean", 3);
        player1.addCardToHand(card1);
        player2.addCardToHand(card2);
    }

    @Test
    void testAddCard() {
        market.addCard(card1);
        assertTrue(market.getTradingCards().contains(card1), "Market should contain the added card.");
    }

    @Test
    void testTradeCardSuccessful() {
        market.addCard(card1);
        player1.getHand().remove(card1); // Simulate giving card to market
        assertTrue(market.tradeCard(player1, player2, card1), "Trade should be successful.");
        assertTrue(player2.getHand().contains(card1), "Player2 should have received the card.");
        assertFalse(player1.getHand().contains(card1), "Player1 should no longer have the card.");
    }

    @Test
    void testTradeCardUnsuccessful() {
        assertFalse(market.tradeCard(player1, player2, card1), "Trade should fail as the card is not in the market.");
    }
}
