import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BlackEyedBeanCreateCardStrategy implements CreateCardStrategy{
    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        LinkedHashMap<Integer, Integer> beanometer = new LinkedHashMap<>() {{
            put(2,1);
            put(4,2);
            put(5,3);
            put(6,4);
        }};
        for (int i = 0; i < 10; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
