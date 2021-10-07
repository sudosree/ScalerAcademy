package interview.thread.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int data = queue.take();
                System.out.println("Consumer consumed: " + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
