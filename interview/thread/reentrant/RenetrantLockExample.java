package interview.thread.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RenetrantLockExample {

    private Lock lock = new ReentrantLock();

    public void outer() {
        lock.lock();
        System.out.println("Calling outer method");
        inner();
        lock.unlock();
    }

    public void inner() {
        lock.lock();
        System.out.println("Calling inner method");
        lock.unlock();
    }

    public static void main(String[] args) {
        RenetrantLockExample lockExample = new RenetrantLockExample();
        lockExample.outer();
    }
}
