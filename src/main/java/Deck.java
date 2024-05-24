import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Deck {
    private Stack<Card> drawDeck = new Stack<>();
    private List<Card> discardDeck = new LinkedList<>();
    private ShufflingStrategy shufflingStrategy;
    private int reshuffleCount = 0;

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
        drawDeck.addAll(gardenBeanCreateCardStrategy.createCard("Garden Bean"));
        // create red beans
        CreateCardStrategy redBeanCreateCardStrategy = new RedBeanCreateCardStrategy();
        drawDeck.addAll(redBeanCreateCardStrategy.createCard("Red Bean"));
        // create black-eyed beans
        CreateCardStrategy blackEyedBeanCreateCardStrategy = new BlackEyedBeanCreateCardStrategy();
        drawDeck.addAll(blackEyedBeanCreateCardStrategy.createCard("Black Eyed Bean"));
        // create soy beans
        CreateCardStrategy soyBeanCreateCardStrategy = new SoyBeanCreateCardStrategy();
        drawDeck.addAll(soyBeanCreateCardStrategy.createCard("Soy Bean"));
        // create green beans
        CreateCardStrategy greenBeanCreateCardStrategy = new GreenBeanCreateCardStrategy();
        drawDeck.addAll(greenBeanCreateCardStrategy.createCard("Green Bean"));
        // create stink beans
        CreateCardStrategy stinkBeanCreateCardStrategy = new StinkBeanCreateCardStrategy();
        drawDeck.addAll(stinkBeanCreateCardStrategy.createCard("Stink Bean"));
        // create chili beans
        CreateCardStrategy chiliBeanCreateCardStrategy = new ChiliBeanCreateCardStrategy();
        drawDeck.addAll(chiliBeanCreateCardStrategy.createCard("Chili Bean"));
        // create blue beans
        CreateCardStrategy blueBeanCreateCardStrategy = new BlueBeanCreateCardStrategy();
        drawDeck.addAll(blueBeanCreateCardStrategy.createCard("Blue Bean"));

        shuffle();
    }

    public void shuffle() {
        if (!discardDeck.isEmpty()) {
            drawDeck.addAll(discardDeck);
            discardDeck.clear();
            shufflingStrategy.shuffle(drawDeck);
            reshuffleCount++;
            System.out.println("Discard deck reshuffled into the draw deck. Reshuffle count: " + reshuffleCount);
        } else {
            shufflingStrategy.shuffle(drawDeck);
        }
    }

    public Card draw() {
        if (drawDeck.isEmpty() && !discardDeck.isEmpty()) {
            shuffle();  // Reshuffle the discard deck back into the draw deck
        }
        return drawDeck.isEmpty() ? null : drawDeck.pop();
    }

    public void discard(Card card) {
        discardDeck.add(card);
    }

    public int getReshuffleCount() {
        return reshuffleCount;
    }

    public boolean isDrawDeckEmpty() {
        return drawDeck.isEmpty();
    }

    public int getSize() {
        return drawDeck.size();
    }
}