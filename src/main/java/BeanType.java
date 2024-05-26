public class BeanType {
    private String name;
    private Beanometer beanometer;

    public BeanType(String name, Beanometer beanometer) {
        this.name = name;
        this.beanometer = beanometer;
    }

    public String getName() {
        return name;
    }

    public Beanometer getBeanometer() {
        return beanometer;
    }
}
