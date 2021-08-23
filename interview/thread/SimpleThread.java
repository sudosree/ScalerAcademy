package interview.thread;

public class SimpleThread extends Thread {

    @Override
    public void run() {
        System.out.println("My interview.thread is in running state");
    }

    public static void main(String[] args) {
        SimpleThread simpleThread = new SimpleThread();
        simpleThread.start();

        Thread t = new Thread(simpleThread);
        t.start();
    }
}
