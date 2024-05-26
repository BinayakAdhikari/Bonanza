import java.util.*;
import java.util.logging.Logger;

public class Game {
    private static final Logger logger = Logger.getLogger(Game.class.getName());

    private List<Player> players;
    private Deck deck;
    private int currentPlayerIndex;
    private int roundCount;
    private int drawPileReshuffles;
    private final int MAX_ROUNDS = 20; // Example value for maximum rounds
    private List<GamePhaseStrategy> phases;

    public Game() {
        this.phases = Arrays.asList(
                new PlantBeanPhase(),
                new TurnOverAndTradePhase(),
                new PlantTurnedOverAndTradedPhase(),
                new DrawBeanCardsPhase()
        );
        this.roundCount = 0;
        this.drawPileReshuffles = 0;
    }

    public void setupGame() {
        System.out.println("Setting up the game...");

        // Create Beans and Beanometers
        Map<Integer, Integer> blueBeanometerMap = new HashMap<>();
        blueBeanometerMap.put(4, 1);
        blueBeanometerMap.put(6, 2);
        blueBeanometerMap.put(8, 3);
        blueBeanometerMap.put(10, 4);
        Beanometer blueBeanometer = new Beanometer(blueBeanometerMap);
        BeanType blueBean = new BeanType("Blue Bean", blueBeanometer);

        Map<Integer, Integer> chiliBeanometerMap = new HashMap<>();
        chiliBeanometerMap.put(3, 1);
        chiliBeanometerMap.put(6, 2);
        chiliBeanometerMap.put(8, 3);
        chiliBeanometerMap.put(9, 4);
        Beanometer chiliBeanometer = new Beanometer(chiliBeanometerMap);
        BeanType chiliBean = new BeanType("Chili Bean", chiliBeanometer);

        Map<Integer, Integer> stinkBeanometerMap = new HashMap<>();
        stinkBeanometerMap.put(3, 1);
        stinkBeanometerMap.put(5, 2);
        stinkBeanometerMap.put(7, 3);
        stinkBeanometerMap.put(8, 4);
        Beanometer stinkBeanometer = new Beanometer(stinkBeanometerMap);
        BeanType stinkBean = new BeanType("Stink Bean", stinkBeanometer);

        Map<Integer, Integer> greenBeanometerMap = new HashMap<>();
        greenBeanometerMap.put(3, 1);
        greenBeanometerMap.put(5, 2);
        greenBeanometerMap.put(6, 3);
        greenBeanometerMap.put(7, 4);
        Beanometer greenBeanometer = new Beanometer(greenBeanometerMap);
        BeanType greenBean = new BeanType("Green Bean", greenBeanometer);

        Map<Integer, Integer> soyBeanometerMap = new HashMap<>();
        soyBeanometerMap.put(2, 1);
        soyBeanometerMap.put(4, 2);
        soyBeanometerMap.put(6, 3);
        soyBeanometerMap.put(7, 4);
        Beanometer soyBeanometer = new Beanometer(soyBeanometerMap);
        BeanType soyBean = new BeanType("Soy Bean", soyBeanometer);

        Map<Integer, Integer> blackEyedBeanometerMap = new HashMap<>();
        blackEyedBeanometerMap.put(2, 1);
        blackEyedBeanometerMap.put(4, 2);
        blackEyedBeanometerMap.put(5, 3);
        blackEyedBeanometerMap.put(6, 4);
        Beanometer blackEyedBeanometer = new Beanometer(blackEyedBeanometerMap);
        BeanType blackEyedBean = new BeanType("Black-Eyed Bean", blackEyedBeanometer);

        Map<Integer, Integer> redBeanometerMap = new HashMap<>();
        redBeanometerMap.put(2, 1);
        redBeanometerMap.put(3, 2);
        redBeanometerMap.put(4, 3);
        redBeanometerMap.put(5, 4);
        Beanometer redBeanometer = new Beanometer(redBeanometerMap);
        BeanType redBean = new BeanType("Red Bean", redBeanometer);

        Map<Integer, Integer> gardenBeanometerMap = new HashMap<>();
        gardenBeanometerMap.put(2, 1);
        gardenBeanometerMap.put(3, 2);
        gardenBeanometerMap.put(4, 3);
        gardenBeanometerMap.put(5, 4);
        Beanometer gardenBeanometer = new Beanometer(gardenBeanometerMap);
        BeanType gardenBean = new BeanType("Garden Bean", gardenBeanometer);

        // Create Cards
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 20; i++) cards.add(new Card(blueBean));
        for (int i = 0; i < 18; i++) cards.add(new Card(chiliBean));
        for (int i = 0; i < 16; i++) cards.add(new Card(stinkBean));
        for (int i = 0; i < 14; i++) cards.add(new Card(greenBean));
        for (int i = 0; i < 12; i++) cards.add(new Card(soyBean));
        for (int i = 0; i < 10; i++) cards.add(new Card(blackEyedBean));
        for (int i = 0; i < 8; i++) cards.add(new Card(redBean));
        for (int i = 0; i < 6; i++) cards.add(new Card(gardenBean));

        // Create Players
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        players = new ArrayList<>();
        players.add(new Player("Alice", plantingStrategy, harvestingStrategy, this));
        players.add(new Player("Bob", plantingStrategy, harvestingStrategy, this));

        // Initialize deck
        ShufflingStrategy shufflingStrategy = new RandomShuffleStrategy();
        deck = new Deck(cards, shufflingStrategy, this);
    }

    public void startGame() {
        setupGame();

        for (Player player : players) {
            player.drawCards(5, deck);
            System.out.println(player.getName() + " has drawn initial 5 cards.");
        }
        while (!isGameOver()) {
            System.out.println("Starting new turn for player: " + players.get(currentPlayerIndex).getName());
            nextTurn();
        }
        endGame();
    }

    public void nextTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        for (GamePhaseStrategy phase : phases) {
            System.out.println("Executing phase: " + phase.getClass().getSimpleName() + " for player: " + currentPlayer.getName());
            phase.execute(currentPlayer, this);
        }
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        roundCount++;
        System.out.println("Round " + roundCount + " completed.");
    }

    public void endGame() {
        Player winner = declareWinner();
        System.out.println("The winner is: " + winner.getName());
        for (Player player : players) {
            System.out.println(player.getName() + " collected " + player.calculateCoins() + " coins.");
        }
    }

    public Player declareWinner() {
        return players.stream()
                .max(Comparator.comparingInt(Player::calculateCoins))
                .orElse(null);
    }

    public boolean isGameOver() {
        return drawPileReshuffles >= 3;
    }

    public void incrementReshuffleCount() {
        drawPileReshuffles++;
    }

    public int getDrawPileReshuffles() {
        return drawPileReshuffles;
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
