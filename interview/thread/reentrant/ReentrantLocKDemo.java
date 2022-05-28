package interview.thread.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocKDemo {
    private Lock lock = new ReentrantLock();
    private int counter = 0;

    private int perform() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
        return counter;
    }

    public static void main(String[] args) {
        ReentrantLocKDemo locKDemo = new ReentrantLocKDemo();
        System.out.println(locKDemo.perform());
    }
}
