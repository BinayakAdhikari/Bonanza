import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();
    private int coins = 0;

    public Player() {
        fields.add(new Field());
        fields.add(new Field());
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void plantBean(int handIndex, int fieldIndex) {
        Card card = hand.remove(handIndex);
        fields.get(fieldIndex).plantBean(card);
    }

    public int harvestField(int fieldIndex) {
        List<Card> harvested = fields.get(fieldIndex).harvestBeans();
        int earnedCoins = calculateCoins(harvested);
        coins += earnedCoins;
        return earnedCoins;
    }

    private int calculateCoins(List<Card> cards) {
        return cards.size() / 2;  // Simplified coin calculation
    }

    public boolean canBuyField() {
        return fields.size() < 3 && coins >= 3;
    }

    public void buyField() {
        if (canBuyField()) {
            fields.add(new Field());
            coins -= 3;
        }
    }

    // Method to access the player's hand of cards
    public List<Card> getHand() {
        return hand;
    }

    // Additional method to get fields for testing and game logic purposes
    public List<Field> getFields() {
        return fields;
    }

    // Method to get the current coin count for the player
    public int getCoins() {
        return coins;
    }
}
