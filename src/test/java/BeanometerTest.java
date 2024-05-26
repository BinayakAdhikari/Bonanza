import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class BeanometerTest {
    @Test
    public void testBeanometer() {
        Map<Integer, Integer> beanometerMap = Map.of(4, 1, 6, 2, 8, 3, 10, 4);
        Beanometer beanometer = new Beanometer(beanometerMap);

        assertEquals(1, beanometer.getHarvestValue(4));
        assertEquals(2, beanometer.getHarvestValue(6));
        assertEquals(0, beanometer.getHarvestValue(3)); // No value for 3
    }
}
