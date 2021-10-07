package interview.thread.deadlock.usinglocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable r1 = new Runnable1(lock1, lock2);
        Runnable r2 = new Runnable2(lock1, lock2);

        Thread t1 = new Thread(r1, "Thread1");
        Thread t2 = new Thread(r2, "Thread2");

        t1.start();
        t2.start();
    }
}
