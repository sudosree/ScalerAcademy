package designprinciple.liskovsubstitution.right;

public class LSVTest {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Area: " + rectangle.getArea());

        Square square = new Square();
        square.setSide(7);
        System.out.println("Area: " + square.getArea());
    }
}
