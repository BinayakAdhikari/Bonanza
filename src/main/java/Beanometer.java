public class Beanometer {

    // Static array holding bean details: name, number of cards, and coin values
    private static final Object[][] beans = new Object[][] {
            {"Blue Bean", 20, new int[]{4, 6, 8, 10}},
            {"Chili Bean", 18, new int[]{3, 6, 8, 9}},
            {"Stink Bean", 16, new int[]{3, 5, 7, 8}},
            {"Green Bean", 14, new int[]{3, 5, 6, 7}},
            {"Soy Bean", 12, new int[]{2, 4, 6, 7}},
            {"Black-Eyed Bean", 10, new int[]{2, 4, 5, 6}},
            {"Red Bean", 8, new int[]{2, 3, 4, 5}},
            {"Garden Bean", 6, new int[]{99, 2, 3, 99}}
    };

    // Method to get the count of bean types
    public static int getBeansCount() {
        return beans.length;
    }

    // Method to get details of a specific bean type
    public static Object[] getBeanDetails(int index) {
        if (index < 0 || index >= getBeansCount()) {
            throw new IllegalArgumentException("Bean index out of bounds: " + index);
        }
        return beans[index];
    }
}
