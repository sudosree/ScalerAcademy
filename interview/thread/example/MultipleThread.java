package interview.thread.example;

public class MultipleThread implements Runnable {

    private Thread thread;
    private String name;

    public MultipleThread(String name) {
        this.name = name;
        this.thread = new Thread(this, name);
        System.out.println("New Thread: " + name + " is created");
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i=1; i<=5; i++) {
                System.out.println(this.name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread: " + this.name + " is interrupted");
        }
        System.out.println("Thread: " + this.name + " is exiting");
    }

    public static void main(String[] args) {
        new MultipleThread("One");
        new MultipleThread("Two");
        new MultipleThread("Three");
    }
}
