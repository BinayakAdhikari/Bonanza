import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {
    @Test
    public void testField() {
        Beanometer beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        BeanType beanType = new BeanType("Blue Bean", beanometer);
        Field field = new Field();

        assertTrue(field.canPlant(new Card(beanType)));

        Card card = new Card(beanType);
        field.addBean(card);
        assertFalse(field.canPlant(new Card(new BeanType("Chili Bean", beanometer))));

        HarvestResult result = field.harvestField();
        assertEquals(0, result.getCoins()); // Not enough cards for coins

        field.addBean(new Card(beanType));
        field.addBean(new Card(beanType));
        field.addBean(new Card(beanType));
        field.addBean(new Card(beanType));

        result = field.harvestField();
        assertEquals(1, result.getCoins());
    }
}
