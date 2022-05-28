package interview.thread.states;

public class NewState implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }

    public static void main(String[] args) {
        Runnable runnable = new NewState();
        Thread thread = new Thread(runnable, "MyThread");
        System.out.println(thread.getState());
    }
}
