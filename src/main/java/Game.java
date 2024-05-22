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
        deck = new Deck(new RandomShuffleStrategy());
        isGameOver = false;
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        for (int i = 0; i < numPlayers; i++) {
            String playerName = "Player " + (i + 1);
            players.add(new Player(playerName, plantingStrategy, harvestingStrategy));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void playTurn(Player player) {
        System.out.println("Starting turn for " + player);

        if (!player.getHand().isEmpty()) {
            Card cardToPlant = player.getHand().remove(0);
            System.out.println(player + " is planting a bean: " + cardToPlant.getBeanType());
            player.plantBean(cardToPlant, 0);  // Plant in the first field
        }

        // Check each field if it can be harvested
        for (int i = 0; i < player.getFields().size(); i++) {
            if (!player.getFields().get(i).getCards().isEmpty()) {
                System.out.println(player + " is harvesting from field " + i);
                player.harvestBeans(i);
            }
        }

        // Draw three cards at the end of the turn
        for (int i = 0; i < 3; i++) {
            Card card = deck.draw();
            if (card != null) {
                player.addCardToHand(card);
                System.out.println(player + " draws a card: " + card.getBeanType());
            }
        }

        System.out.println("Ending turn for " + player + "\n");
    }

    public void startGame() {
        while (!isGameOver) {
            for (Player player : players) {
                playTurn(player);
                if (deck.getSize() == 0) {  // Check if deck is empty
                    System.out.println("The deck is empty. Game over.");
                    isGameOver = true;
                    break;
                }
            }
        }
    }

    // Getter for isGameOver
    public boolean isGameOver() {
        return isGameOver;
    }

    public static void main(String[] args) {
        Game game = new Game(5);  // Start a game with 4 players
        game.startGame();
    }
}
