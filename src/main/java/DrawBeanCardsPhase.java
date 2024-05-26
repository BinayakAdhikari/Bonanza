public class DrawBeanCardsPhase implements GamePhaseStrategy {
    @Override
    public void execute(Player player, Game game) {
        player.drawCards(3, game.getDeck());
    }
}
