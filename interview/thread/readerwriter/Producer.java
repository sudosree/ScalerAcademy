package interview.thread.readerwriter;

public class Producer implements Runnable {

    private SharedObject sharedObject;

    public Producer(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        sharedObject.put(1, "Sree");
        sharedObject.put(2, "Sourav");
        sharedObject.put(3, "Riya");
        sharedObject.put(4, "Alex");
    }
}
