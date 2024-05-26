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

    public Player(String name, PlantingStrategy plantingStrategy, HarvestingStrategy harvestingStrategy) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.coins = new ArrayList<>();
        this.isStartingPlayer = false;
        this.plantingStrategy = plantingStrategy;
        this.harvestingStrategy = harvestingStrategy;
        this.fields.add(new Field());
        this.fields.add(new Field());
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
        plantingStrategy.plant(firstCard, this);
        if (!hand.isEmpty()) {
            Card secondCard = hand.remove(0);
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
            }
        }
        market.trade(this);
        for (Card card : turnedOverCards) {
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
                return;
            }
        }
        Field firstField = fields.get(0);
        HarvestResult result = harvestingStrategy.harvest(firstField, this);
        coins.addAll(result.getHarvestedCards());
        firstField.addBean(new Card(beanType));
    }

    public void receiveTrade(List<Card> cards) {
        for (Card card : cards) {
            plantBean(card.getBeanType());
        }
    }

    public void giveGift(List<Card> cards, Player player) {
        for (Card card : cards) {
            hand.remove(card);
            player.takeGift(card);
        }
    }

    public void takeGift(Card card) {
        hand.add(card);
    }
}
