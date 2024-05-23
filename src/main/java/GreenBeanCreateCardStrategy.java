import java.util.ArrayList;
import java.util.LinkedHashMap;

public class GreenBeanCreateCardStrategy implements CreateCardStrategy{
    @Override
    public ArrayList<Card> createCard( String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        LinkedHashMap<Integer, Integer> beanometer = new LinkedHashMap<>() {{
            put(3, 1);
            put(5, 2);
            put(6, 3);
            put(7, 4);
        }};
        for (int i = 0; i < 14; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
