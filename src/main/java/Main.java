import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create Beans and Beanometers
        Map<Integer, Integer> blueBeanometerMap = new HashMap<>();
        blueBeanometerMap.put(4, 1);
        blueBeanometerMap.put(6, 2);
        blueBeanometerMap.put(8, 3);
        blueBeanometerMap.put(10, 4);
        Beanometer blueBeanometer = new Beanometer(blueBeanometerMap);
        BeanType blueBean = new BeanType("Blue Bean", blueBeanometer);

        Map<Integer, Integer> chiliBeanometerMap = new HashMap<>();
        chiliBeanometerMap.put(3, 1);
        chiliBeanometerMap.put(6, 2);
        chiliBeanometerMap.put(8, 3);
        chiliBeanometerMap.put(9, 4);
        Beanometer chiliBeanometer = new Beanometer(chiliBeanometerMap);
        BeanType chiliBean = new BeanType("Chili Bean", chiliBeanometer);

        Map<Integer, Integer> stinkBeanometerMap = new HashMap<>();
        stinkBeanometerMap.put(3, 1);
        stinkBeanometerMap.put(5, 2);
        stinkBeanometerMap.put(7, 3);
        stinkBeanometerMap.put(8, 4);
        Beanometer stinkBeanometer = new Beanometer(stinkBeanometerMap);
        BeanType stinkBean = new BeanType("Stink Bean", stinkBeanometer);

        Map<Integer, Integer> greenBeanometerMap = new HashMap<>();
        greenBeanometerMap.put(3, 1);
        greenBeanometerMap.put(5, 2);
        greenBeanometerMap.put(6, 3);
        greenBeanometerMap.put(7, 4);
        Beanometer greenBeanometer = new Beanometer(greenBeanometerMap);
        BeanType greenBean = new BeanType("Green Bean", greenBeanometer);

        Map<Integer, Integer> soyBeanometerMap = new HashMap<>();
        soyBeanometerMap.put(2, 1);
        soyBeanometerMap.put(4, 2);
        soyBeanometerMap.put(6, 3);
        soyBeanometerMap.put(7, 4);
        Beanometer soyBeanometer = new Beanometer(soyBeanometerMap);
        BeanType soyBean = new BeanType("Soy Bean", soyBeanometer);

        Map<Integer, Integer> blackEyedBeanometerMap = new HashMap<>();
        blackEyedBeanometerMap.put(2, 1);
        blackEyedBeanometerMap.put(4, 2);
        blackEyedBeanometerMap.put(5, 3);
        blackEyedBeanometerMap.put(6, 4);
        Beanometer blackEyedBeanometer = new Beanometer(blackEyedBeanometerMap);
        BeanType blackEyedBean = new BeanType("Black-Eyed Bean", blackEyedBeanometer);

        Map<Integer, Integer> redBeanometerMap = new HashMap<>();
        redBeanometerMap.put(2, 1);
        redBeanometerMap.put(3, 2);
        redBeanometerMap.put(4, 3);
        redBeanometerMap.put(5, 4);
        Beanometer redBeanometer = new Beanometer(redBeanometerMap);
        BeanType redBean = new BeanType("Red Bean", redBeanometer);

        Map<Integer, Integer> gardenBeanometerMap = new HashMap<>();
        gardenBeanometerMap.put(2, 1);
        gardenBeanometerMap.put(3, 2);
        gardenBeanometerMap.put(4, 3);
        gardenBeanometerMap.put(5, 4);
        Beanometer gardenBeanometer = new Beanometer(gardenBeanometerMap);
        BeanType gardenBean = new BeanType("Garden Bean", gardenBeanometer);

        // Create Cards
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 20; i++) cards.add(new Card(blueBean));
        for (int i = 0; i < 18; i++) cards.add(new Card(chiliBean));
        for (int i = 0; i < 16; i++) cards.add(new Card(stinkBean));
        for (int i = 0; i < 14; i++) cards.add(new Card(greenBean));
        for (int i = 0; i < 12; i++) cards.add(new Card(soyBean));
        for (int i = 0; i < 10; i++) cards.add(new Card(blackEyedBean));
        for (int i = 0; i < 8; i++) cards.add(new Card(redBean));
        for (int i = 0; i < 6; i++) cards.add(new Card(gardenBean));

        // Create Players
        PlantingStrategy plantingStrategy = new SimplePlantingStrategy();
        HarvestingStrategy harvestingStrategy = new SimpleHarvestingStrategy();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", plantingStrategy, harvestingStrategy));
        players.add(new Player("Bob", plantingStrategy, harvestingStrategy));

        // Initialize and start the game
        ShufflingStrategy shufflingStrategy = new RandomShuffleStrategy();
        Game game = new Game(players, cards, shufflingStrategy);
        game.startGame();
    }
}
