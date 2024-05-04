import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MarketTest {
    private Market market;
    private Player playerA;
    private Player playerB;

    @Before
    public void setUp() {
        market = new Market();
        playerA = new Player();
        playerB = new Player();

        // Add some cards to playerA's hand for trading
        playerA.addCardToHand(new Card("Blue Bean", 2));
        playerA.addCardToHand(new Card("Green Bean", 3));
    }

    @Test
    public void testAddCards() {
        List<Card> cardsToAdd = new ArrayList<>();
        cardsToAdd.add(new Card("Red Bean", 4));
        cardsToAdd.add(new Card("Black Bean", 2));
        market.addCards(cardsToAdd);

        assertEquals("Trading area should have 2 cards", 2, market.getTurnover().size());
    }

    @Test
    public void testTradeSuccessful() {
        Card cardToTrade = new Card("Blue Bean", 2);
        playerA.addCardToHand(cardToTrade);

        // Add the card to the market and trade it to playerB
        List<Card> cardsToAdd = new ArrayList<>();
        cardsToAdd.add(cardToTrade);
        market.addCards(cardsToAdd);

        boolean tradeSuccess = market.trade(playerA, playerB, cardToTrade);
        assertTrue("Trade should succeed", tradeSuccess);
        assertFalse("Player A should not have the traded card", playerA.getHand().contains(cardToTrade));
        assertTrue("Player B should have received the traded card", playerB.getHand().contains(cardToTrade));
        assertEquals("Trading area should be empty after the trade", 0, market.getTurnover().size());
    }

    @Test
    public void testTradeUnsuccessful() {
        Card cardToTrade = new Card("Nonexistent Bean", 5);
        boolean tradeSuccess = market.trade(playerA, playerB, cardToTrade);

        assertFalse("Trade should fail since the card is not in the market", tradeSuccess);
    }

    @Test
    public void testGetTradingArea() {
        List<Card> cardsToAdd = new ArrayList<>();
        cardsToAdd.add(new Card("Yellow Bean", 3));
        cardsToAdd.add(new Card("Blue Bean", 2));
        market.addCards(cardsToAdd);

        List<Card> tradingArea = market.getTurnover();
        assertEquals("Trading area should contain 2 cards", 2, tradingArea.size());
    }
}
