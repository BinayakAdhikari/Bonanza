import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Deck deck;
    private Market market;
    private boolean isGameOver;

    public Game(int numPlayers) {
        players = new ArrayList<>();
        market = new Market();
        deck = new Deck(new RandomShuffleStrategy()); // Initialize deck with a random shuffle strategy
        isGameOver = false;
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        for (int i = 0; i < numPlayers; i++) {
            String playerName = "Player " + (i + 1);
            players.add(new Player(playerName, plantingStrategy, harvestingStrategy));
        }
    }

    public void playTurn(Player player) {
        System.out.println("Starting turn for " + player);

        if (!player.getHand().isEmpty()) {
            Card cardToPlant = player.getHand().remove(0);
            System.out.println(player + " is planting a bean: " + cardToPlant.getBeanType());
            player.plantBean(cardToPlant, 0);
        }

        for (int i = 0; i < player.getFields().size(); i++) {
            if (!player.getFields().get(i).getCards().isEmpty()) {
                System.out.println(player + " is harvesting from field " + i);
                HarvestResult result = player.harvestBeans(i);
                for (Card card : result.getHarvestedCards()) {
                    deck.discard(card);  // Discard each harvested card
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            Card card = deck.draw();
            if (card != null) {
                player.addCardToHand(card);
                System.out.println(player + " draws a card: " + card.getBeanType());
            }
        }

        if (deck.getReshuffleCount() >= 3) {
            System.out.println("Game over: The discard pile has been reshuffled three times.");
            isGameOver = true;
        }

        System.out.println("Ending turn for " + player + "\n");
    }

    public void startGame() {
        while (!isGameOver) {
            for (Player player : players) {
                playTurn(player);
            }
        }
        System.out.println("Game Over. Thank you for playing!");
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public static void main(String[] args) {
        Game game = new Game(5);  // Corrected to 5 players
        game.startGame();
    }
}
