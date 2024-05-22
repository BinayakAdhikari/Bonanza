import java.util.ArrayList;
import java.util.HashMap;

public class RedBeanCreateCardStrategy implements CreateCardStrategy{
    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        HashMap<Integer, Integer> beanometer = new HashMap<Integer,Integer>() {{
            put(2,1);
            put(3,2);
            put(4,3);
            put(5,4);
        }};
        for (int i = 0; i < 8; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
