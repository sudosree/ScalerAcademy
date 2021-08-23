public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() {

    }

    /*
    * Not interview.thread safe implementation
    * */
    /*public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }*/

    /*
    * Thread safe implementation, bad performance
    * */
    /*public synchronized static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }*/

    /*
    * Thread safe implementation, double locking mechanism
    * */
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
