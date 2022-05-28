package interview.thread.example;

public class MyThreadClass extends Thread {

    private String name;

    public MyThreadClass(String name) {
//        this.name = name;
        super(name);
    }

    @Override
    public void run() {
//        System.out.println("Current Thread: " + name);
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread th1 = new MyThreadClass("Thread1");
        th1.start();

        Thread th2 = new MyThreadClass("Thread2");
        th2.start();

    }
}
