package designpattern.singleton;

public class SingletonDoubleCheckedLocking {
    private static SingletonDoubleCheckedLocking instance;

    private SingletonDoubleCheckedLocking() {
        System.out.println("Singleton Class");
    }

    public static SingletonDoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
