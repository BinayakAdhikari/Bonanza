import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class BeanMafiaBossTest {

    private BeanMafiaBoss boss;
    private List<Card> discardPile;
    private Beanometer beanometer;

    @BeforeEach
    public void setUp() {
        beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        boss = new BeanMafiaBoss("Boss Name", 5);
        discardPile = new ArrayList<>();
    }

    @Test
    public void testBeanMafiaBossCreation() {
        assertEquals("Boss Name", boss.getName());
        assertEquals(5, boss.getHarvestThreshold());
        assertEquals(0, boss.getCoins());
        assertTrue(boss.getField().isEmpty());
    }

    @Test
    public void testPlantBean() {
        Card card = new Card(new BeanType("Black Bean", beanometer));
        boss.plantBean(card);
        assertEquals(1, boss.getField().size());
        assertEquals("Black Bean", boss.getField().get(0).getBeanType().getName());
    }

    @Test
    public void testShouldHarvest() {
        for (int i = 0; i < 5; i++) {
            boss.plantBean(new Card(new BeanType("Black Bean", beanometer)));
        }
        assertTrue(boss.shouldHarvest());
    }

    @Test
    public void testCalculateCoins() {
        assertEquals(4, boss.calculateCoins(8));
        assertEquals(3, boss.calculateCoins(7));
        assertEquals(2, boss.calculateCoins(5));
        assertEquals(1, boss.calculateCoins(3));
        assertEquals(0, boss.calculateCoins(2));
    }

    @Test
    public void testHarvest() {
        for (int i = 0; i < 5; i++) {
            boss.plantBean(new Card(new BeanType("Black Bean", beanometer)));
        }
        boss.harvest(discardPile);
        assertEquals(2, boss.getCoins());
        assertTrue(boss.getField().isEmpty());
        assertEquals(5, discardPile.size());
    }

    @Test
    public void testHarvestWithoutThreshold() {
        for (int i = 0; i < 3; i++) {
            boss.plantBean(new Card(new BeanType("Black Bean", beanometer)));
        }
        boss.harvest(discardPile);
        assertEquals(0, boss.getCoins());
        assertFalse(boss.getField().isEmpty());
        assertEquals(0, discardPile.size());
    }

    @Test
    public void testAddCoins() {
        boss.addCoins(5);
        assertEquals(5, boss.getCoins());
    }
}
