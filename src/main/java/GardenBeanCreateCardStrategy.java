import java.util.ArrayList;
import java.util.LinkedHashMap;

public class GardenBeanCreateCardStrategy implements CreateCardStrategy{
    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        LinkedHashMap<Integer, Integer> beanometer = new LinkedHashMap<>() {{
            put(2, 2);
            put(3, 3);
        }};
        for (int i = 0; i < 6; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
