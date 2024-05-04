import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FieldTest {
    private Field field;

    @Before
    public void setUp() {
        field = new Field();
    }

    @Test
    public void testPlantBean() {
        Card card = new Card("Black Bean", 2);
        field.plantBean(card);
        assertEquals("Field should have 1 bean", 1, field.getNumberOfBeans());
    }

    @Test
    public void testHarvestBeans() {
        field.plantBean(new Card("Black Bean", 2));
        field.plantBean(new Card("Black Bean", 2));
        List<Card> harvested = field.harvestBeans();
        assertEquals("Field should be empty after harvesting", 0, field.getNumberOfBeans());
        assertEquals("Should harvest 2 beans", 2, harvested.size());
    }

    @Test
    public void testGetNumberOfBeans() {
        field.plantBean(new Card("Black Bean", 2));
        field.plantBean(new Card("Black Bean", 3));
        assertEquals("Field should have 2 beans", 2, field.getNumberOfBeans());
    }
}
