package designprinciple.interfacesegregation.wrong;

public class BearCarer implements BearKeeper {

    @Override
    public void washTheBear() {
        System.out.println("Washing the bear");
    }

    @Override
    public void feedTheBear() {
        System.out.println("Feeding the bear");
    }

    @Override
    public void petTheBear() {
        System.out.println("Do not want to pet the bear");
    }
}
