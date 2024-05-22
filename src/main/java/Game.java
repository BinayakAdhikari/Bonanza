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
        deck = new Deck();
        isGameOver = false;
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(plantingStrategy, harvestingStrategy));
        }
    }

    public void playTurn(Player player) {
        if (!player.getHand().isEmpty()) {
            Card cardToPlant = player.getHand().remove(0);
            player.plantBean(cardToPlant, 0);  // Plant in the first field
        }

        // Check each field if it can be harvested
        player.getFields().forEach(field -> {
            if (!field.getCards().isEmpty()) {
                player.harvestBeans(player.getFields().indexOf(field));
            }
        });

        // Draw three cards at the end of the turn
        for (int i = 0; i < 3; i++) {
            Card card = deck.draw();
            if (card != null) {
                player.addCardToHand(card);
            }
        }

        // Check if the game should end
        if (deck.getSize() == 0) {
            isGameOver = true;
        }
    }

    public void startGame() {
        while (!isGameOver) {
            for (Player player : players) {
                playTurn(player);
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public static void main(String[] args) {
        Game game = new Game(4);  // Start a game with 4 players
        game.startGame();
    }
}
