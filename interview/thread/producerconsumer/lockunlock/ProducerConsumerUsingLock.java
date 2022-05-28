package interview.thread.producerconsumer.lockunlock;

public class ProducerConsumerUsingLock {

    public static void main(String[] args) throws InterruptedException {
        int capacity = 4;
        BlockingQueue sharedObject = new BlockingQueue(capacity);
        Producer producer = new Producer(sharedObject, 4);
        Consumer consumer = new Consumer(sharedObject, 4);
        Thread prod1 = new Thread(producer, "Producer Thread1");
        Thread cons1 = new Thread(consumer, "Consumer Thread1");
        prod1.start();
        cons1.start();
    }
}
