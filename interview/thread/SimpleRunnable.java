package interview.thread;

public class SimpleRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Current thread: " + Thread.currentThread().getName());
        System.out.println("My interview.thread is in running state");
    }

    public static void main(String[] args) {
        SimpleRunnable simpleRunnable = new SimpleRunnable();
        simpleRunnable.run();
        simpleRunnable.run();

        Thread thread = new Thread(simpleRunnable);
        thread.start();
    }
}
