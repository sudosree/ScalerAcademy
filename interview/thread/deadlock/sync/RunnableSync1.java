package interview.thread.deadlock.sync;

public class RunnableSync1 implements Runnable {

    private Object lock1;
    private Object lock2;

    public RunnableSync1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " is trying to acquire lock1");
        synchronized (lock1) {
            System.out.println(name + " locked lock1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is trying to acquire lock2");
            synchronized (lock2) {
                System.out.println(name + " locked lock2");
                System.out.println("Executing the operation");
                System.out.println(name + " is trying to release lock2");
            }
            System.out.println(name + " unlocked lock2");
            System.out.println(name + " is trying to release lock1");
        }
        System.out.println(name + " unlocked lock1");
    }
}
