package interview.thread.producerconsumer.lockunlock;

public class Producer implements Runnable {

    private BlockingQueue sharedObject;
    private int capacity;

    public Producer(BlockingQueue sharedObject, int capacity) {
        this.sharedObject = sharedObject;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        int num = 1;
        while (num <= capacity) {
            sharedObject.addData(num);
            num++;
        }
    }
}
