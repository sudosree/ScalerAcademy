package interview.thread.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int taken = -1;
        while (taken != 4) {
            try {
                taken = queue.take();
                System.out.println("Consumer consumed: " + taken);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
