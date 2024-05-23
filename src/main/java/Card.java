public class Card {
    private String beanType;
    private int beanometer;

    public Card(String beanType, int beanometer) {
        this.beanType = beanType;
        this.beanometer = beanometer;
    }

    public String getBeanType() {
        return beanType;
    }

    public int getBeanometer() {
        return beanometer;
    }
}
