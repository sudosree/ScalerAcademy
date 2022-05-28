package interview.thread.readerwriter.readwritelock;

public class Writer implements Runnable {
    private MyReaderWriterLock readWriteLock;

    public Writer(MyReaderWriterLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void run() {
        readWriteLock.writeLock();
        System.out.println(Thread.currentThread().getName() + " started writing");
        readWriteLock.writeUnlock();
        System.out.println(Thread.currentThread().getName() + " finished writing");
    }
}
