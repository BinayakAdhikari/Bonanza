import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class HarvestResultTest {
    @Test
    public void testHarvestResult() {
        Beanometer beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        BeanType beanType = new BeanType("Blue Bean", beanometer);
        List<Card> harvestedCards = Arrays.asList(new Card(beanType), new Card(beanType));
        HarvestResult result = new HarvestResult(1, harvestedCards);

        assertEquals(1, result.getCoins());
        assertEquals(harvestedCards, result.getHarvestedCards());
    }
}
