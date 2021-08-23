package interview.designpattern.products;

public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Truck deliver cargo by land in a box");
    }
}
