package interview.thread.readerwriter;

public class ReaderWriter {

    private int resourceCounter = 0;

    public void read() throws InterruptedException {
        synchronized (this) {
            // the shared resource is currently being updated by a writer thread
            while (resourceCounter == -1) {
                // wait for the shared resource to become available again
                wait();
            }
            resourceCounter++;
        }
        System.out.println(Thread.currentThread().getName() + " started reading");
        synchronized (this) {
            resourceCounter--;
            // when the resource becomes available it notifies the writer thread
            if (resourceCounter == 0) {
                notify();
            }
            System.out.println(Thread.currentThread().getName() + " finished reading");
        }
    }

    public void write() throws InterruptedException {
        synchronized (this) {
            // if the resource is not available because of some other reader threads or some writer
            // threads accessing the shared resource then wait
            while (resourceCounter != 0) {
                wait();
            }
            // writer thread will start updating the resource;
            resourceCounter = -1;
        }
        System.out.println(Thread.currentThread().getName() + " started writing");
        synchronized (this) {
            resourceCounter = 0;
            notifyAll();
            notify();
            System.out.println(Thread.currentThread().getName() + " finished writing");
        }
    }

    public static void main(String[] args) {
        ReaderWriter rw = new ReaderWriter();

        Thread reader1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rw.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread reader2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rw.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rw.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        reader1.start();
        reader2.start();
        writer.start();
    }
}
