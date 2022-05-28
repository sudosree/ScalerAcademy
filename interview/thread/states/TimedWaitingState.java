package interview.thread.states;

public class TimedWaitingState implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new TimedWaitingState();
        Thread thread = new Thread(runnable, "MyThread");
        thread.start();
        // gives enough time for thread to complete
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}
