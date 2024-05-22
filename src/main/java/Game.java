import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Deck deck;
    private boolean isGameOver;

    public Game(int numPlayers) {
        players = new ArrayList<>();
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(plantingStrategy, harvestingStrategy));
        }
        deck = new Deck();
        isGameOver = false;
    }

    public void playTurn(Player player) {
        if (!player.getHand().isEmpty()) {
            Card cardToPlant = player.getHand().remove(0);
            player.plantBean(cardToPlant, 0);  // Plant in the first field
        }

        if (player.getFields().get(1).getNumberOfBeans() > 0) {
            player.harvestBeans(1);
        }

        for (int i = 0; i < 3; i++) {
            Card card = deck.draw();
            if (card != null) {
                player.addCardToHand(card);
            }
        }
    }

    public void startGame() {
        while (!isGameOver) {
            for (Player player : players) {
                playTurn(player);
                if (deck.draw() == null) {
                    isGameOver = true;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game(4);
        game.startGame();
    }
}
