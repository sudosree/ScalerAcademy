package interview.thread.example;

public class DaemonThread implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("New Thread: " + name);
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Current Thread " + name + " is a daemon thread.");
        } else {
            System.out.println("Current Thread " + name + " is a user thread.");
        }
    }

    public static void main(String[] args) {
        DaemonThread d = new DaemonThread();

        Thread t1 = new Thread(d, "One");
        Thread t2 = new Thread(d, "Two");
        Thread t3 = new Thread(d, "Three");

        t1.setDaemon(true);
        t1.start();
        t2.start();
        t3.setDaemon(true);
        t3.start();
    }
}
