package interview.thread.runnable;

public class LambdaRunnable {

    private Runnable myRunnable() {
        Runnable runnable = () -> {
            System.out.println("Current thread: " + Thread.currentThread().getName());
        };
        return runnable;
    }

    public static void main(String[] args) {
        LambdaRunnable lR = new LambdaRunnable();
        Runnable runnable = lR.myRunnable();
        runnable.run();

        Thread th1 = new Thread(runnable, "Thread1");
        th1.start();

        Thread th2 = new Thread(runnable, "Thread2");
        th2.start();
    }
}
