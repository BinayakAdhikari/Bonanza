import java.util.Collections;
import java.util.List;

// Concrete Shuffling Strategy
public class RandomShuffleStrategy implements ShufflingStrategy {
    @Override
    public void shuffle(List<Card> cards) {
        Collections.shuffle(cards);
    }
}