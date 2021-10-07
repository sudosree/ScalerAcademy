package interview.thread.producerconsumer.lockunlock;

public class ProducerConsumerUsingLock {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerSharedObject sharedObject = new ProducerConsumerSharedObject();
        Producer producer = new Producer(sharedObject);
        Consumer consumer = new Consumer(sharedObject);
        for (int i=0; i<8; i++) {
            // creates producer and consumer threads
            Thread pTh = new Thread(producer, "Producer " + i);
            Thread cTh = new Thread(consumer, "Consumer " + i);
//            Thread.sleep(1000);
            // start the producer and consumer threads
            pTh.start();
//            Thread.sleep(1000);
            cTh.start();
        }
    }
}
