public class PlantBeanPhase implements GamePhaseStrategy {
    @Override
    public void execute(Player player, Game game) {
        player.plantBeanFromHand();
    }
}
