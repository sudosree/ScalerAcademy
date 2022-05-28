package interview.thread.states;

public class WaitingState implements Runnable {

    public static Thread thread1;

    @Override
    public void run() {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(thread1.getName() + " " + thread1.getState());
            }
        }, "MyThread2");
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(thread2.getName() + " " + thread2.getState());
    }

    public static void main(String[] args) {
        Runnable runnable = new WaitingState();
        thread1 = new Thread(runnable, "MyThread1");
        thread1.start();
    }
}
