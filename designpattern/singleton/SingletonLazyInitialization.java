package designpattern.singleton;

public class SingletonLazyInitialization {
    private static SingletonLazyInitialization instance;

    private SingletonLazyInitialization() {
        System.out.println("Singleton class");
    }

    public static SingletonLazyInitialization getInstance() {
        if (instance == null) {
            instance = new SingletonLazyInitialization();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("Instance : " + SingletonLazyInitialization.getInstance());
        System.out.println("Instance : " + SingletonLazyInitialization.getInstance());
        System.out.println("Instance : " + SingletonLazyInitialization.getInstance());
    }
}
