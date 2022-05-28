package interview.thread.readerwriter.readwritelock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReaderWriterLock {

    private int resourceCounter = 0;
    private Lock lock = new ReentrantLock();
    private Condition readPhase = lock.newCondition();
    private Condition writePhase = lock.newCondition();

    public void readLock() {
        lock.lock();
        try {
            System.out.println("Resource counter: " + resourceCounter);
            // there is a writer thread that is currently writing
            while (resourceCounter == -1) {
                readPhase.await();
            }
            resourceCounter++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void readUnlock() {
        lock.lock();
        try {
            resourceCounter--;
            // signal the writer thread
            if (resourceCounter == 0) {
                writePhase.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void writeLock() {
        lock.lock();
        try {
            // if there are reader threads or writer thread that is
            // currently reading or writing
            System.out.println("Resource counter: " + resourceCounter);
            while (resourceCounter != 0) {
                writePhase.await();
            }
            // the writer thread will start writing
            resourceCounter = -1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void writeUnlock() {
        lock.lock();
        try {
           resourceCounter = 0;
           readPhase.signalAll();
           writePhase.signal();
        } finally {
            lock.unlock();
        }
    }
}
