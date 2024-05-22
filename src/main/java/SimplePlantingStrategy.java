public class SimplePlantingStrategy implements PlantingStrategy {
    @Override
    public void plantBean(Player player, Card card, int fieldIndex) {
        player.getFields().get(fieldIndex).plantBean(card);
    }
}
