import java.util.ArrayList;
import java.util.HashMap;

public class ChiliBeanCreateCardStrategy implements CreateCardStrategy{
    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        HashMap<Integer, Integer> beanometer = new HashMap<Integer,Integer>() {{
            put(3,1);
            put(6,2);
            put(8,3);
            put(9,4);
        }};
        for (int i = 0; i < 18; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
