import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private List<Field> fields;
    private List<Card> coins;
    private boolean isStartingPlayer;
    private PlantingStrategy plantingStrategy;
    private HarvestingStrategy harvestingStrategy;
    private Game currentGame;

    public Player(String name, PlantingStrategy plantingStrategy, HarvestingStrategy harvestingStrategy, Game currentGame) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.coins = new ArrayList<>();
        this.isStartingPlayer = false;
        this.plantingStrategy = plantingStrategy;
        this.harvestingStrategy = harvestingStrategy;
        this.fields.add(new Field());
        this.fields.add(new Field());
        this.currentGame = currentGame;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Card> getCoins() {
        return coins;
    }

    public boolean isStartingPlayer() {
        return isStartingPlayer;
    }

    public void setStartingPlayer(boolean startingPlayer) {
        isStartingPlayer = startingPlayer;
    }

    public void plantBeanFromHand() {
        if (hand.isEmpty()) return;
        Card firstCard = hand.remove(0);
        System.out.println(name + " plants " + firstCard.getBeanType().getName() + " from hand.");
        plantingStrategy.plant(firstCard, this);
        if (!hand.isEmpty()) {
            Card secondCard = hand.remove(0);
            System.out.println(name + " plants " + secondCard.getBeanType().getName() + " from hand.");
            plantingStrategy.plant(secondCard, this);
        }
    }

    public void turnOverAndTradeBeans(Game game) {
        Market market = new Market(game.getPlayers());
        List<Card> turnedOverCards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Card card = game.getDeck().drawCard();
            if (card != null) {
                turnedOverCards.add(card);
                System.out.println(name + " turns over " + card.getBeanType().getName() + " from the deck.");
            }
        }
        market.trade(this);
        for (Card card : turnedOverCards) {
            System.out.println(name + " plants turned over " + card.getBeanType().getName() + " from the deck.");
            plantingStrategy.plant(card, this);
        }
    }

    public void plantTurnedOverAndTradedBeans() {
        // Implement logic to plant turned-over and traded beans if needed
    }

    public void drawCards(int num, Deck deck) {
        for (int i = 0; i < num; i++) {
            Card card = deck.drawCard();
            if (card != null) {
                hand.add(card);
                System.out.println(name + " draws " + card.getBeanType().getName() + " from the deck.");
            }
        }
    }

    public int calculateCoins() {
        return coins.size();
    }

    public String getFieldStatus() {
        StringBuilder status = new StringBuilder();
        for (Field field : fields) {
            status.append(field.getStatus()).append("\n");
        }
        return status.toString();
    }

    public void plantBean(BeanType beanType) {
        for (Field field : fields) {
            if (field.canPlant(new Card(beanType))) {
                field.addBean(new Card(beanType));
                System.out.println(name + " plants " + beanType.getName() + " in a field.");
                return;
            }
        }
        Field firstField = fields.get(0);
        HarvestResult result = harvestingStrategy.harvest(firstField, this);
        coins.addAll(result.getHarvestedCards());
        System.out.println(name + " harvests a field and gains " + result.getCoins() + " coins.");
        discardRemainingCards(result.getHarvestedCards());
        firstField.addBean(new Card(beanType));
    }

    public void receiveTrade(List<Card> cards) {
        for (Card card : cards) {
            System.out.println(name + " receives " + card.getBeanType().getName() + " from trade.");
            plantBean(card.getBeanType());
        }
    }

    public void giveGift(List<Card> cards, Player player) {
        for (Card card : cards) {
            hand.remove(card);
            player.takeGift(card);
            System.out.println(name + " gives " + card.getBeanType().getName() + " to " + player.getName() + " as a gift.");
        }
    }

    public void takeGift(Card card) {
        hand.add(card);
        System.out.println(name + " takes " + card.getBeanType().getName() + " as a gift.");
    }

    private void discardRemainingCards(List<Card> harvestedCards) {
        for (Card card : harvestedCards) {
            if (!card.isCoin()) {
                // Add non-coin cards to the discard pile
                currentGame.getDeck().discardCard(card);
                System.out.println(name + " discards " + card.getBeanType().getName() + " card.");
            }
        }
    }

    private Game getCurrentGame() {
        return currentGame;
    }
}
