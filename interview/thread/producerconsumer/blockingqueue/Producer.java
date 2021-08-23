package interview.thread.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i=1;i<=4;i++) {
            try {
                queue.put(i);
                System.out.println("Producer produced: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
