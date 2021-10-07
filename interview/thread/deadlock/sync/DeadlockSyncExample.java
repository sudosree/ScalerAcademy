package interview.thread.deadlock.sync;

public class DeadlockSyncExample {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable r1 = new RunnableSync1(lock1, lock2);
        Runnable r2 = new RunnableSync2(lock1, lock2);

        Thread t1 = new Thread(r1, "Thread1");
        Thread t2 = new Thread(r2, "Thread2");

        t1.start();
        t2.start();
    }
}
