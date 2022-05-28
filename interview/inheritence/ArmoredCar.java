package interview.inheritence;

public class ArmoredCar extends Car {

    public ArmoredCar() {

    }

    public ArmoredCar(String name, String model, String color) {
        super(name, model, color);
    }

    public static void speedUp() {
        System.out.println("Color: " + Car.getColor());
        System.out.println("Speeding up ArmoredCar");
    }
}
