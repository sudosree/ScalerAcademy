package interview.thread.example;

public class MultipleThreadExample implements Runnable {

    @Override
    public void run() {
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        for (int i=1; i<=5; i++) {
            Thread thread = new Thread("Thread" + i) {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is executing....");
                }
            };
            thread.start();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new MultipleThreadExample();
        Thread th = new Thread(runnable, "MyThread");
        th.start();
    }
}
