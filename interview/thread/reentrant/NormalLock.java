package interview.thread.reentrant;

public class NormalLock {
    Lock lock = new Lock();

    public void outer() throws InterruptedException {
        lock.lock();
        System.out.println("Calling outer method");
        inner();
        lock.unlock();
    }

    public void inner() throws InterruptedException {
        lock.lock();
        System.out.println("Calling inner method");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        NormalLock normalLock = new NormalLock();
        normalLock.outer();
    }
}
