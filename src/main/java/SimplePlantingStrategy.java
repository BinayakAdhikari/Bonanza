import java.util.List;

public class SimplePlantingStrategy implements PlantingStrategy {
    @Override
    public void plant(Card card, Player player) {
        boolean planted = false;
        for (Field field : player.getFields()) {
            if (field.canPlant(card)) {
                field.addBean(card);
                System.out.println("[" + player.getName() + "] plants " + card.getBeanType().getName() + " in a field.");
                planted = true;
                break;
            }
        }
        if (!planted) {
            Field firstField = player.getFields().get(0);
            if (!firstField.getBeans().isEmpty()) {
                HarvestResult result = player.getCurrentGame().getHarvestingStrategy().harvest(firstField, player);
                player.getCoins().addAll(result.getHarvestedCards());
//                System.out.println("[" + player.getName() + "] harvests " + firstField.getBeans().size() + " " + firstField.getBeans().get(0).getBeanType().getName() + "(s) and gains " + result.getCoins() + " coins.");
                discardRemainingCards(result.getHarvestedCards(), player);
            }
            firstField.addBean(card);
            System.out.println("[" + player.getName() + "] plants " + card.getBeanType().getName() + " in the newly harvested field.");
        }
    }

    private void discardRemainingCards(List<Card> harvestedCards, Player player) {
        for (Card card : harvestedCards) {
            if (!card.isCoin()) {
                player.getCurrentGame().getDeck().discardCard(card);
                System.out.println("[" + player.getName() + "] discards " + card.getBeanType().getName() + " card.");
            }
        }
    }
}
