package interview.thread.producerconsumer.lockunlock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerSharedObject {
    private static final int CAPACITY = 4;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Random random = new Random();

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void put() throws InterruptedException {
        lock.lock();
        try {
            String name = Thread.currentThread().getName();
            // if the queue is full then wait for the queue to have some space left
            while (queue.size() == CAPACITY) {
                System.out.println("Queue is full !!! Producer " + name + " is waiting for some space");
                notFull.await();
            }
            // if the queue is not full then insert data
            int data = random.nextInt();
            queue.offer(data);
            System.out.println("Producer " + name + " has produced data " + data);
            // signal the consumer thread that the queue is not empty
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException {
        lock.lock();
        try {
            String name = Thread.currentThread().getName();
            // if the queue is empty then wait for the queue to have some data
            while (queue.size() == 0) {
                System.out.println("Queue is empty !!! Consumer " + name + " is waiting for some data");
                notEmpty.await();
            }
            // if the queue is not empty then remove data
            int data = queue.poll();
            System.out.println("Consumer " + name + " has consumed data " + data);
            // signal the producer thread that the queue is not full
            notFull.await();
        } finally {
            lock.unlock();
        }
    }
}
