import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    private ShufflingStrategy shufflingStrategy;

    public Deck(ShufflingStrategy strategy) {
        this.shufflingStrategy = strategy;
        // Initialize deck with cards
        initializeDeck();
    }

    private void initializeDeck() {
        // Add cards to the deck
        // create concrete Create Card Strategies
        // create garden beans
        CreateCardStrategy gardenBeanCreateCardStrategy = new GardenBeanCreateCardStrategy();
        cards.addAll(gardenBeanCreateCardStrategy.createCard("Garden Bean"));
        // create red beans
        CreateCardStrategy redBeanCreateCardStrategy = new RedBeanCreateCardStrategy();
        cards.addAll(redBeanCreateCardStrategy.createCard("Red Bean"));
        // create black-eyed beans
        CreateCardStrategy blackEyedBeanCreateCardStrategy = new BlackEyedBeanCreateCardStrategy();
        cards.addAll(blackEyedBeanCreateCardStrategy.createCard("Black Eyed Bean"));
        // create soy beans
        CreateCardStrategy soyBeanCreateCardStrategy = new SoyBeanCreateCardStrategy();
        cards.addAll(soyBeanCreateCardStrategy.createCard("Soy Bean"));
        // create green beans
        CreateCardStrategy greenBeanCreateCardStrategy = new GreenBeanCreateCardStrategy();
        cards.addAll(greenBeanCreateCardStrategy.createCard("Green Bean"));
        // create stink beans
        CreateCardStrategy stinkBeanCreateCardStrategy = new StinkBeanCreateCardStrategy();
        cards.addAll(stinkBeanCreateCardStrategy.createCard("Stink Bean"));
        // create chili beans
        CreateCardStrategy chiliBeanCreateCardStrategy = new ChiliBeanCreateCardStrategy();
        cards.addAll(chiliBeanCreateCardStrategy.createCard("Chili Bean"));
        // create blue beans
        CreateCardStrategy blueBeanCreateCardStrategy = new BlueBeanCreateCardStrategy();
        cards.addAll(blueBeanCreateCardStrategy.createCard("Blue Bean"));

        shuffle();
    }

    public void shuffle() {
        shufflingStrategy.shuffle(cards);
    }

    public Card draw() {
        return cards.isEmpty() ? null : cards.remove(0);
    }

    public int getSize() {
        return cards.size();
    }
}