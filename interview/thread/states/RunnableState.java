package interview.thread.states;

public class RunnableState implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }

    public static void main(String[] args) {
        Runnable runnable = new RunnableState();
        Thread thread = new Thread(runnable, "MyThread");
        thread.start();
        System.out.println(thread.getState());
    }
}
