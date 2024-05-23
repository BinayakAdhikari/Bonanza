import java.util.ArrayList;
import java.util.LinkedHashMap;

public class StinkBeanCreateCardStrategy implements CreateCardStrategy{
    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        LinkedHashMap<Integer, Integer> beanometer = new LinkedHashMap<>() {{
            put(3, 1);
            put(5, 2);
            put(7, 3);
            put(8, 4);
        }};
        for (int i = 0; i < 16; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
