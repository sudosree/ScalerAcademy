package interview.thread.readerwriter.readwritelock;

public class Reader implements Runnable {
    private MyReaderWriterLock readWriteLock;

    public Reader(MyReaderWriterLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void run() {
        readWriteLock.readLock();
        // multiple readers can read the data
        System.out.println(Thread.currentThread().getName() + " started reading");
        readWriteLock.readUnlock();
        System.out.println(Thread.currentThread().getName() + " finished reading");
    }
}
