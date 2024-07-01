public interface HarvestingStrategy {
    HarvestResult harvest(Field field, Player player);
    void harvest(BeanMafiaBoss boss, Deck deck);
}
