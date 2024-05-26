import java.util.List;

public class SimpleHarvestingStrategy implements HarvestingStrategy {
    @Override
    public HarvestResult harvest(Field field, Player player) {
        return field.harvestField();
    }
}
