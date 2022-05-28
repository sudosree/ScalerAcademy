package interview.thread.producerconsumer.lockunlock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void addData(int num) {
        lock.lock();
        try {
            String name = Thread.currentThread().getName();
            // if the queue is full then wait for the queue to have some space left
            while (queue.size() == this.capacity) {
                System.out.println("Queue is full !!! Producer " + name + " is waiting for some space");
                notFull.await();
            }
            // if the queue is not full then insert data
            queue.offer(num);
            System.out.println("Producer " + name + " has produced data " + num);
            // signal the consumer thread that the queue is not empty
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void removeData() {
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
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
