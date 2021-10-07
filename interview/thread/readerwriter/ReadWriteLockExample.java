package interview.thread.readerwriter;

public class ReadWriteLockExample {
    public static void main(String[] args) {

        SharedObject sharedObject = new SharedObject();
        Producer prod = new Producer(sharedObject);
        Consumer cons = new Consumer(sharedObject);
        Thread prodT = new Thread(prod, "Producer");
        Thread consT = new Thread(cons, "Consumer");
        prodT.start();
        consT.start();
    }
}
