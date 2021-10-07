package interview.thread.deadlock.usinglocks;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable {

    private Lock lock1;
    private Lock lock2;

    public Runnable1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " is trying to acquire lock1");
        lock1.lock();
        System.out.println(name + " locked lock1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " is trying to acquire lock2");
        lock2.lock();
        System.out.println(name + " locked lock2");

        System.out.println("Executing the operation");

        System.out.println(name + " is trying to release lock2");
        lock2.unlock();
        System.out.println(name + " unlocked lock2");
        System.out.println(name + " is trying to release lock1");
        lock1.unlock();
        System.out.println(name + " unlocked lock1");
    }
}
