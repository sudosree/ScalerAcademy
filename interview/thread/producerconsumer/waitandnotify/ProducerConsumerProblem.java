package interview.thread.producerconsumer.waitandnotify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {

    static class ProducerConsumer {
        Queue<Integer> queue = new LinkedList<>();
        int capacity = 4;

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized(this) {
                    // check if the queue is full, if it is full then
                    // wait until and unless it has some space left
                    while (queue.size() == capacity) {
                        wait();     // the producer interview.thread goes to waiting state and releases the lock
                    }
                    // insert data in the queue
                    queue.offer(value);

                    System.out.println("Producer produced: " + value);
                    value++;
                    // notify the consumer interview.thread that it can now start consuming data from the queue
                    notify();
                    // makes the program easier to understand
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // check if the queue is empty, if it is empty then
                    // wait until and unless it has some data
                    while (queue.size() == 0) {
                        wait();
                    }
                    // remove data from the queue
                    int val = queue.remove();

                    System.out.println("Consumer consumed: " + val);

                    // notify the producer interview.thread that it can now start producing data and insert into the queue
                    notify();
                    // makes the program easier to understand
                    Thread.sleep(1000);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        // Create a Producer Thread
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create a Consumer Thread
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // start both the threads
        producer.start();
        consumer.start();

//        producer.join();
//        consumer.join();
    }
}
