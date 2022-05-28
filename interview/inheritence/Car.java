package interview.inheritence;

public class Car {
    private String name;
    private String model;
    private static String color;

    public Car() {

    }

    public Car(String name, String model, String color) {
        this.name = name;
        this.model = model;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public static void speedUp() {
        System.out.println("Speeding up Car");
    }

    public static String getColor() {
        return color;
    }
}
