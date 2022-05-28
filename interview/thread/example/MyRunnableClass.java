package interview.thread.example;

public class MyRunnableClass implements Runnable {

    @Override
    public void run() {
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnableClass();
        runnable.run();
        runnable.run();

        Thread th1 = new Thread(runnable, "Thread1");
        th1.start();

        Thread th2 = new Thread(runnable, "Thread2");
        th2.start();
    }
}
