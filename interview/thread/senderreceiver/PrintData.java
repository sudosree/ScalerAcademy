package interview.thread.senderreceiver;

public class PrintData {
    private boolean transfer = true;

    public synchronized void send(int num) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " send data: " + num);
        transfer = false;
        notify();
    }

    public synchronized void receive(int num) {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " receive data: " + num);
        transfer = true;
        notify();
    }
}
