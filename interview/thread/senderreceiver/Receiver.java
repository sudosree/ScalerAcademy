package interview.thread.senderreceiver;

public class Receiver implements Runnable {
    private int max;
    private PrintData printData;

    public Receiver(int max, PrintData printData) {
        this.max = max;
        this.printData = printData;
    }

    @Override
    public void run() {
        int num = 1;
        while (num <= max) {
            printData.receive(num);
            num++;
        }
    }
}
