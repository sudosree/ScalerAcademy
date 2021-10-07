package interview.thread.producerconsumer.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    private Random random;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
        random = new Random();
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            try {
                int data = random.nextInt();
                queue.put(data);
                System.out.println("Producer produced: " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
