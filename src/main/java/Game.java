import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Game {
    private List<Player> players;
    private Deck deck;
    private int currentPlayerIndex;
    private int roundCount;
    private int drawPileReshuffles;
    private List<GamePhaseStrategy> phases;

    public Game(List<Player> players, List<Card> cards, ShufflingStrategy shufflingStrategy) {
        this.players = players;
        this.deck = new Deck(cards, shufflingStrategy);
        this.currentPlayerIndex = 0;
        this.roundCount = 0;
        this.drawPileReshuffles = 0;
        this.phases = Arrays.asList(
                new PlantBeanPhase(),
                new TurnOverAndTradePhase(),
                new PlantTurnedOverAndTradedPhase(),
                new DrawBeanCardsPhase()
        );
    }

    public void startGame() {
        for (Player player : players) {
            player.drawCards(5, deck);
        }
        while (!isGameOver()) {
            nextTurn();
        }
        endGame();
    }

    public void nextTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        for (GamePhaseStrategy phase : phases) {
            phase.execute(currentPlayer, this);
        }
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void endGame() {
        Player winner = declareWinner();
        System.out.println("The winner is: " + winner.getName());
    }

    public Player declareWinner() {
        return players.stream()
                .max(Comparator.comparingInt(Player::calculateCoins))
                .orElse(null);
    }

    public boolean isGameOver() {
        return drawPileReshuffles >= 3;
    }

    public void reshuffleDrawPile() {
        drawPileReshuffles++;
        deck.reshuffleDiscardIntoDraw();
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
