package interview.thread.states;

public class BlockedState implements Runnable {
    private Object mutex = new Object();

    @Override
    public void run() {
        synchronized (mutex) {
            System.out.println(Thread.currentThread().getName() + " is in the critical section");
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new BlockedState();
        Thread t1 = new Thread(runnable, "Thread1");
        Thread t2 = new Thread(runnable, "Thread2");
        t1.start();
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
