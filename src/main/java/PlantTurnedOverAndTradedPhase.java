public class PlantTurnedOverAndTradedPhase implements GamePhaseStrategy {
    @Override
    public void execute(Player player, Game game) {
        player.plantTurnedOverAndTradedBeans();
    }
}
