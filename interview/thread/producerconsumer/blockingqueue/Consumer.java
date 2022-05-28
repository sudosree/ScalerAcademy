package interview.thread.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;
    private int capacity;

    public Consumer(BlockingQueue<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        int size = capacity;
        try {
            while (size > 0) {
                int data = queue.take();
                System.out.println("Consumer consumed: " + data);
                size--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
