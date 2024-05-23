import java.util.*;

public class Card {
    private String beanType;
    private LinkedHashMap<Integer, Integer> beanometer;

    public Card(String beanType, LinkedHashMap<Integer , Integer> beanometer) {
        this.beanType = beanType;
        this.beanometer = beanometer;
    }

    public String getBeanType() {
        return beanType;
    }

    public int getBeanometer(int numberOfCards) {
        List<Integer> keys = new ArrayList<>(beanometer.keySet());
        for (int i = keys.size() -1; i> -1; i--) {
            if (numberOfCards  >= keys.get(i)){
                // add cards to discard pile and remove cards
                int coins = beanometer.get(keys.get(i));
                return coins;
            }
        }
        return 0;
    }
}
