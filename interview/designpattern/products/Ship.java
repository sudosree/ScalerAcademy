package interview.designpattern.products;

public class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("Ship deliver cargo by sea in a container");
    }
}
