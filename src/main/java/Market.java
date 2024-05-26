import java.util.List;

public class Market {
    private List<Player> players;

    public Market(List<Player> players) {
        this.players = players;
    }

    public void trade(Player currentPlayer) {
        System.out.println("[" + currentPlayer.getName() + "] is trading...");
        // Implement trade logic here
        // Example: trade first card from currentPlayer's hand with the first card from the next player's hand
        for (Player player : players) {
            if (player != currentPlayer && !player.getHand().isEmpty()) {
                Card currentPlayerCard = currentPlayer.getHand().remove(0);
                Card playerCard = player.getHand().remove(0);
                currentPlayer.getHand().add(playerCard);
                player.getHand().add(currentPlayerCard);
                System.out.println("[" + currentPlayer.getName() + "] trades " + currentPlayerCard.getBeanType().getName() + " with " + player.getName() + " for " + playerCard.getBeanType().getName());
                break;
            }
        }
    }
}
