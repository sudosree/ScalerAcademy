package interview.thread.runnable;

public class AnonymousRunnable {

    private Runnable getRunnable() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("Current Thread: " + Thread.currentThread().getName());
            }
        };
        return run;
    }

    public static void main(String[] args) {
        AnonymousRunnable anonymousRunnable = new AnonymousRunnable();
        Runnable myRun = anonymousRunnable.getRunnable();
        myRun.run();

        Thread th1 = new Thread(myRun, "Thread1");
        th1.start();

        Thread th2 = new Thread(myRun, "Thread2");
        th2.start();
    }
}
