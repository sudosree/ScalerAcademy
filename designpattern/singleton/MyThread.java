package designpattern.singleton;

public class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.name + " has created " + SingletonThreadSafe.getInstance());
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread1");
        t1.run();
        MyThread t2 = new MyThread("Thread2");
        t2.run();
    }
}
