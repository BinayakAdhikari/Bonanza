import java.util.ArrayList;
import java.util.HashMap;

// concrete create card strategy
public class BlueBeanCreateCardStrategy implements CreateCardStrategy{

    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        HashMap<Integer, Integer> beanometer = new HashMap<Integer,Integer>() {{
            put(4,1);
            put(6,2);
            put(8,3);
            put(9,4);
        }};
        for (int i = 0; i < 20; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
