package interview.thread.producerconsumer.lockunlock;

public class Producer implements Runnable {

    private ProducerConsumerSharedObject sharedObject;

    public Producer(ProducerConsumerSharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        try {
            sharedObject.put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
