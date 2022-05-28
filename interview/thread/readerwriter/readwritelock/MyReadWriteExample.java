package interview.thread.readerwriter.readwritelock;

public class MyReadWriteExample {

    public static void main(String[] args) {
        MyReaderWriterLock readWriteLock = new MyReaderWriterLock();

        Reader reader = new Reader(readWriteLock);
        Writer writer = new Writer(readWriteLock);

        Thread readThread1 = new Thread(reader, "Reader Thread1");
        Thread readThread2 = new Thread(reader, "Reader Thread2");
        Thread readThread3 = new Thread(reader, "Reader Thread3");
        Thread writeThread1 = new Thread(writer, "Writer Thread1");
        Thread writeThread2 = new Thread(writer, "Writer Thread2");
        Thread writeThread3 = new Thread(writer, "Writer Thread3");
        readThread1.start();
        readThread2.start();
        readThread3.start();
        writeThread1.start();
        writeThread2.start();
        writeThread3.start();
    }
}
