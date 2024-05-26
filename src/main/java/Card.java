public class Card {
    private BeanType beanType;
    private boolean isCoin;

    public Card(BeanType beanType) {
        this.beanType = beanType;
        this.isCoin = false;
    }

    public BeanType getBeanType() {
        return beanType;
    }

    public boolean isCoin() {
        return isCoin;
    }

    public void setCoin(boolean coin) {
        isCoin = coin;
    }
}
