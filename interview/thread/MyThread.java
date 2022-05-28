package interview.thread;

public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Current thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread1");
        thread1.start();

        MyThread thread2 = new MyThread("Thread2");
        thread2.start();

        Runnable runnable = () -> System.out.println("Thread: " + Thread.currentThread().getName());
        Thread thread3 = new Thread(runnable);
        thread3.setName("thread3");
        thread3.start();
        Thread thread4 = new Thread(runnable);
        thread4.setName("thread4");
        thread4.start();
    }
}