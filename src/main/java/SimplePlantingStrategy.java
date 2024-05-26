public class SimplePlantingStrategy implements PlantingStrategy {
    @Override
    public void plant(Card card, Player player) {
        for (Field field : player.getFields()) {
            if (field.canPlant(card)) {
                field.addBean(card);
                return;
            }
        }
        // If no field can plant this card, harvest the first field and plant the card there
        Field firstField = player.getFields().get(0);
        HarvestResult result = player.getCurrentGame().getHarvestingStrategy().harvest(firstField, player);
        player.getCoins().addAll(result.getHarvestedCards());
        player.getCurrentGame().getDeck().discardCard(card);
        firstField.addBean(card);
    }
}
