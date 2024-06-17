public interface HarvestingStrategy {
    HarvestResult harvest(Field field, Player player);
    void harvestMafia(BeanMafiaBoss boss, Deck deck);
}
