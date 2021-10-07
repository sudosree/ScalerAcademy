package interview.thread.producerconsumer.lockunlock;

public class Consumer implements Runnable {

    private ProducerConsumerSharedObject sharedObject;

    public Consumer(ProducerConsumerSharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        try {
            sharedObject.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
