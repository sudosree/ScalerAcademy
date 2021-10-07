package interview.thread.readerwriter;

public class Consumer implements Runnable {

    private SharedObject sharedObject;

    public Consumer(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        sharedObject.remove(1);
        sharedObject.get(1);
        sharedObject.get(2);
        sharedObject.get(3);
        sharedObject.get(4);
    }
}
