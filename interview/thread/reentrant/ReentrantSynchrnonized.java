package interview.thread.reentrant;

public class ReentrantSynchrnonized {

    private Object mutex = new Object();

    public void outer() {
        synchronized (mutex) {
            System.out.println("Calling from outer block");
            inner();
        }
    }

    public void inner() {
        synchronized (mutex) {
            System.out.println("Calling from inner block");
        }
    }

    public static void main(String[] args) {
        ReentrantSynchrnonized sync = new ReentrantSynchrnonized();
        sync.outer();
    }
}
