package interview.thread.producerconsumer.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    private int capacity;
    private Random random;

    public Producer(BlockingQueue<Integer> queue, int capacity) {
        this.queue = queue;
        random = new Random();
        this.capacity = capacity;
    }

    @Override
    public void run() {
        /*for (int i=1; i<=3; i++) {
            try {
                int data = random.nextInt();
                queue.put(data);
                System.out.println("Producer produced: " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        int num = 1;
        while (num < capacity) {
            try {
                queue.put(num);
                System.out.println("Producer produced: " + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
        }
    }
}
