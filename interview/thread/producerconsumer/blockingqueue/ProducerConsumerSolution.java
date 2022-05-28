package interview.thread.producerconsumer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Producer Consumer problem solution using Blocking Queue
 */
public class ProducerConsumerSolution {

    public static void main(String[] args) throws InterruptedException {
        int capacity = 4;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        Producer producer = new Producer(queue, capacity);
        Consumer consumer = new Consumer(queue, capacity);

        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);

        pThread.start();
        cThread.start();
    }
}
