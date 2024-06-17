import java.util.*;
import java.util.logging.Logger;

public class Game {
    private static final Logger logger = Logger.getLogger(Game.class.getName());

    private List<Player> players;
    private Deck deck;
    private int currentPlayerIndex;
    private int roundCount;
    private int drawPileReshuffles;
    private List<GamePhaseStrategy> phases;
    private PlantingStrategy plantingStrategy;
    private HarvestingStrategy harvestingStrategy;
    private List<BeanMafiaBoss> beanMafiaBosses;

    public Game() {
        this.phases = Arrays.asList(
                new PlantBeanPhase(),
                new TurnOverAndTradePhase(),
                new PlantTurnedOverAndTradedPhase(),
                new DrawBeanCardsPhase()
        );
        this.roundCount = 0;
        this.drawPileReshuffles = 0;
        this.plantingStrategy = new SimplePlantingStrategy();
        this.harvestingStrategy = new SimpleHarvestingStrategy();
        this.beanMafiaBosses = new ArrayList<>();
        initializeBeanMafiaBosses();
    }

    private void initializeBeanMafiaBosses() {
        beanMafiaBosses.add(new BeanMafiaBoss("Al Cabohne", 3));
        beanMafiaBosses.add(new BeanMafiaBoss("Don Corlebohne", 2));
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

        // Add beans from Al Cabohne extension
        Map<Integer, Integer> kidneyBeanometerMap = new HashMap<>();
        kidneyBeanometerMap.put(4, 1);
        kidneyBeanometerMap.put(7, 2);
        kidneyBeanometerMap.put(9, 3);
        kidneyBeanometerMap.put(11, 4);
        Beanometer kidneyBeanometer = new Beanometer(kidneyBeanometerMap);
        BeanType kidneyBean = new BeanType("Kidney Bean", kidneyBeanometer);

        Map<Integer, Integer> fireBeanometerMap = new HashMap<>();
        fireBeanometerMap.put(3, 1);
        fireBeanometerMap.put(6, 2);
        fireBeanometerMap.put(8, 3);
        fireBeanometerMap.put(10, 4);
        Beanometer fireBeanometer = new Beanometer(fireBeanometerMap);
        BeanType fireBean = new BeanType("Fire Bean", fireBeanometer);

        Map<Integer, Integer> puffBeanometerMap = new HashMap<>();
        puffBeanometerMap.put(2, 1);
        puffBeanometerMap.put(4, 2);
        puffBeanometerMap.put(6, 3);
        puffBeanometerMap.put(8, 4);
        Beanometer puffBeanometer = new Beanometer(puffBeanometerMap);
        BeanType puffBean = new BeanType("Puff Bean", puffBeanometer);

        Map<Integer, Integer> broadBeanometerMap = new HashMap<>();
        broadBeanometerMap.put(3, 1);
        broadBeanometerMap.put(5, 2);
        broadBeanometerMap.put(7, 3);
        broadBeanometerMap.put(9, 4);
        Beanometer broadBeanometer = new Beanometer(broadBeanometerMap);
        BeanType broadBean = new BeanType("Broad Bean", broadBeanometer);

        Map<Integer, Integer> frenchBeanometerMap = new HashMap<>();
        frenchBeanometerMap.put(4, 1);
        frenchBeanometerMap.put(6, 2);
        frenchBeanometerMap.put(8, 3);
        frenchBeanometerMap.put(10, 4);
        Beanometer frenchBeanometer = new Beanometer(frenchBeanometerMap);
        BeanType frenchBean = new BeanType("French Bean", frenchBeanometer);

        Map<Integer, Integer> runnerBeanometerMap = new HashMap<>();
        runnerBeanometerMap.put(2, 1);
        runnerBeanometerMap.put(4, 2);
        runnerBeanometerMap.put(6, 3);
        runnerBeanometerMap.put(8, 4);
        Beanometer runnerBeanometer = new Beanometer(runnerBeanometerMap);
        BeanType runnerBean = new BeanType("Runner Bean", runnerBeanometer);

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
        // Add cards for new beans
        for (int i = 0; i < 20; i++) cards.add(new Card(kidneyBean));
        for (int i = 0; i < 18; i++) cards.add(new Card(fireBean));
        for (int i = 0; i < 16; i++) cards.add(new Card(puffBean));
        for (int i = 0; i < 14; i++) cards.add(new Card(broadBean));
        for (int i = 0; i < 12; i++) cards.add(new Card(frenchBean));
        for (int i = 0; i < 10; i++) cards.add(new Card(runnerBean));

        // Create Players
        players = new ArrayList<>();
        players.add(new Player("Player 1", plantingStrategy, harvestingStrategy, this));
        players.add(new Player("Player 2", plantingStrategy, harvestingStrategy, this));
        players.add(new Player("Player 3", plantingStrategy, harvestingStrategy, this));

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
            System.out.println("\n--- New Turn ---");
            System.out.println("Current Player: " + players.get(currentPlayerIndex).getName());
            nextTurn();
            System.out.println("--- Turn Ended ---\n");
        }
        endGame();
    }

    public void nextTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("\n--- New Turn ---");
        System.out.println("Current Player: " + currentPlayer.getName());

        for (GamePhaseStrategy phase : phases) {
            System.out.println("\nExecuting phase: " + phase.getClass().getSimpleName() + " for player: " + currentPlayer.getName());
            phase.execute(currentPlayer, this);
            System.out.println("Phase: " + phase.getClass().getSimpleName() + " completed.");
        }

        // Ensure to check and give beans to Mafia at appropriate phase
        currentPlayer.checkAndGiveBeanToAllMafias(beanMafiaBosses);

        // Check and handle Bean Mafia Bosses' fields
        for (BeanMafiaBoss boss : beanMafiaBosses) {
            System.out.println("MAFIA [" + boss.getName() + "] current field size: " + boss.getField().size());
            harvestingStrategy.harvestMafia(boss, deck);
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        roundCount++;
        System.out.println("Round " + roundCount + " completed.");
        System.out.println(currentPlayer.getName() + " now has " + currentPlayer.calculateCoins() + " coins.");

        // Log the total coins for each Mafia boss at the end of the turn
        for (BeanMafiaBoss boss : beanMafiaBosses) {
            System.out.println("MAFIA [" + boss.getName() + "] has " + boss.getCoins() + " coins.");
        }
        System.out.println("--- Turn Ended ---\n");
    }

    public void endGame() {
        Player winner = declareWinner();
        System.out.println("The winner is: " + winner.getName());
        for (Player player : players) {
            System.out.println(player.getName() + " collected " + player.calculateCoins() + " coins.");
        }

        // Log the final coins for each Mafia boss at the end of the game
        for (BeanMafiaBoss boss : beanMafiaBosses) {
            System.out.println("MAFIA [" + boss.getName() + "] final coins: " + boss.getCoins());
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

    public PlantingStrategy getPlantingStrategy() {
        return plantingStrategy;
    }

    public HarvestingStrategy getHarvestingStrategy() {
        return harvestingStrategy;
    }

    public List<BeanMafiaBoss> getBeanMafiaBosses() {
        return beanMafiaBosses;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
