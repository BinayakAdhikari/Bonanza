import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ChiliBeanCreateCardStrategy implements CreateCardStrategy{
    @Override
    public ArrayList<Card> createCard(String beanType) {
        ArrayList<Card> cards = new ArrayList<>();
        LinkedHashMap<Integer, Integer> beanometer = new LinkedHashMap<>() {{
            put(3, 1);
            put(6, 2);
            put(8, 3);
            put(9, 4);
        }};
        for (int i = 0; i < 18; i++ ){
            cards.add(new Card(beanType,beanometer));
        }
        return cards;
    }
}
