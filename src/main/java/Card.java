import java.util.Dictionary;
import java.util.HashMap;

public class Card {
    private String beanType;
    private HashMap beanometer;

    public Card(String beanType, HashMap<Integer , Integer> beanometer) {
        this.beanType = beanType;
        this.beanometer = beanometer;
    }

    public String getBeanType() {
        return beanType;
    }

    public int getBeanometer(int numberOfCards) {
        return (int) beanometer.get(numberOfCards);
    }
}
