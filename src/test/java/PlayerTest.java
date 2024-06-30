import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Game game;
    private Player player;
    private Beanometer beanometer;
    private BeanType beanType;
    private Card card;
    private MafiaBossHarvestingStrategy harvestingStrategy = new MafiaBossHarvestingStrategy();

    @BeforeEach
    public void setUp() {
        game = new Game();
        game.setupGame();
        player = game.getPlayers().get(0);

        beanometer = new Beanometer(Map.of(4, 1, 6, 2, 8, 3, 10, 4));
        beanType = new BeanType("Blue Bean", beanometer);
        card = new Card(beanType);
    }

    @Test
    public void testPlayerInitialization() {
        assertEquals("Player 1", player.getName());
        assertTrue(player.getHand().isEmpty());
        assertEquals(2, player.getFields().size());
    }

    @Test
    public void testPlantBeanFromHand() {
        player.getHand().add(card);
        System.out.println("Player's hand before planting: " + player.getHand().size());
        player.plantBeanFromHand();
        System.out.println("Player's hand after planting: " + player.getHand().size());
        System.out.println("Field status: " + player.getFieldStatus());

        assertTrue(player.getHand().isEmpty());
        String[] fieldStatuses = player.getFieldStatus().split("\n");
        assertEquals("1 Blue Bean(s)", fieldStatuses[0].trim());
        assertEquals("Empty field", fieldStatuses[1].trim());
    }

    // Additional tests to ensure comprehensive coverage
    @Test
    public void testCheckAndGiveBeanToMafia() {
        BeanMafiaBoss mafiaBoss = new BeanMafiaBoss("Mafia Boss", 3);
        player.getFields().get(0).addBean(new Card(new BeanType("Black Bean", beanometer)));
        player.getFields().get(0).addBean(new Card(new BeanType("Red Bean", beanometer)));
        player.getFields().get(1).addBean(new Card(new BeanType("Green Bean", beanometer)));

        player.checkAndGiveBeanToMafia(mafiaBoss);

        assertEquals(3, mafiaBoss.getField().size());
        assertEquals("Black Bean", mafiaBoss.getField().get(0).getBeanType().getName());
        assertEquals("Red Bean", mafiaBoss.getField().get(1).getBeanType().getName());
        assertEquals("Green Bean", mafiaBoss.getField().get(2).getBeanType().getName());

        assertTrue(mafiaBoss.shouldHarvest());

        List<Card> discardPile = new ArrayList<>();
        harvestingStrategy.harvestMafia(mafiaBoss, discardPile);

        assertEquals(1, mafiaBoss.getCoins());
        assertTrue(mafiaBoss.getField().isEmpty());
        assertEquals(3, discardPile.size());
    }
}
