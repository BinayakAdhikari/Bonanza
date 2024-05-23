import java.util.ArrayList;
import java.util.LinkedHashMap;

// concrete create card strategy
public class BlueBeanCreateCardStrategy implements CreateCardStrategy{

    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        LinkedHashMap<Integer, Integer> beanometer = new LinkedHashMap<>() {{
            put(4, 1);
            put(6, 2);
            put(8, 3);
            put(9, 4);
        }};
        for (int i = 0; i < 20; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
