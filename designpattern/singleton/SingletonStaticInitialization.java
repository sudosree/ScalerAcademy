package designpattern.singleton;

public class SingletonStaticInitialization {
    private static SingletonStaticInitialization instance;

    private SingletonStaticInitialization() {
        System.out.println("Singleton Class");
    }

    static {
        try {
            instance = new SingletonStaticInitialization();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton");
        }
    }

    public static SingletonStaticInitialization getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("Instance: " + SingletonStaticInitialization.getInstance());
        System.out.println("Instance: " + SingletonStaticInitialization.getInstance());
        System.out.println("Instance: " + SingletonStaticInitialization.getInstance());
    }
}
