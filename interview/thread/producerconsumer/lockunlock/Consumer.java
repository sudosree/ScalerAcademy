package interview.thread.producerconsumer.lockunlock;

public class Consumer implements Runnable {

    private BlockingQueue sharedObject;
    private int capacity;

    public Consumer(BlockingQueue sharedObject, int capacity) {
        this.sharedObject = sharedObject;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        int size = capacity;
        while (size > 0) {
            sharedObject.removeData();
            size--;
        }
    }
}
