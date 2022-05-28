package designprinciple.interfacesegregation.right;

public class BearCarer implements BearCleaner, BearFeeder {

    @Override
    public void washTheBear() {
        System.out.println("Washing the bear");
    }

    @Override
    public void feedTheBear() {
        System.out.println("Feeding the bear");
    }

}
