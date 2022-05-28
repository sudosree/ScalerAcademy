package designpattern.singleton;

public class SingletonEagerInitialization {

    private static final SingletonEagerInitialization instance = new SingletonEagerInitialization();

    private SingletonEagerInitialization() {
        System.out.println("Singleton Class");
    }

    public static SingletonEagerInitialization getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("Instance: " + SingletonEagerInitialization.getInstance());
        System.out.println("Instance: " + SingletonEagerInitialization.getInstance());
        System.out.println("Instance: " + SingletonEagerInitialization.getInstance());
    }
}
