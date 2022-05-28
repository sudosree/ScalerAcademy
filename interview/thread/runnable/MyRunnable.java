package interview.thread.runnable;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Current thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        runnable.run();

        Thread thread1 = new Thread(runnable, "Thread1");
        thread1.start();

        Thread thread2 = new Thread(runnable, "Thread2");
        thread2.start();
    }
}