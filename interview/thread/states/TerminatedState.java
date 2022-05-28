package interview.thread.states;

public class TerminatedState implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new TerminatedState();
        Thread thread = new Thread(runnable, "MyThread");
        thread.start();
        // gives enough time for thread to complete
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}
