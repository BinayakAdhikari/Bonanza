public class SimplePlantingStrategy implements PlantingStrategy {
    @Override
    public void plant(Card card, Player player) {
        player.plantBean(card.getBeanType());
    }
}
