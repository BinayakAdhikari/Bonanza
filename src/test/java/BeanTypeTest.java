import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BeanTypeTest {
    @Test
    public void testBeanType() {
        Beanometer beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        BeanType beanType = new BeanType("Blue Bean", beanometer);

        assertEquals("Blue Bean", beanType.getName());
        assertEquals(beanometer, beanType.getBeanometer());
    }
}
