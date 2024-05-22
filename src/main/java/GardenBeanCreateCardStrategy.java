import java.util.ArrayList;
import java.util.HashMap;

public class GardenBeanCreateCardStrategy implements CreateCardStrategy{
    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        HashMap<Integer, Integer> beanometer = new HashMap<Integer,Integer>() {{
            put(2,2);
            put(3,3);
        }};
        for (int i = 0; i < 6; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
