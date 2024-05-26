public class TurnOverAndTradePhase implements GamePhaseStrategy {
    @Override
    public void execute(Player player, Game game) {
        player.turnOverAndTradeBeans(game);
    }
}
