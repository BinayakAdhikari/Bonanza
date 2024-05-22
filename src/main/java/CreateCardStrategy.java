import java.util.ArrayList;

// create card strategy interface
public interface CreateCardStrategy {
    ArrayList<Card> createCard(String beanType);
}
