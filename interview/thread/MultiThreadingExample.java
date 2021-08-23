package interview.thread;

public class MultiThreadingExample {

    static class MultiThreadingDemo implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<8;i++) {
            Thread thread = new Thread(new MultiThreadingDemo());
            Thread.sleep(1000);
            thread.start();
        }
    }
}
