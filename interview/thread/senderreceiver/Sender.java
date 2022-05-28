package interview.thread.senderreceiver;

public class Sender implements Runnable {
    private int max;
    private PrintData printData;

    public Sender(int max, PrintData printData) {
        this.max = max;
        this.printData = printData;
    }

    @Override
    public void run() {
        int num = 1;
        while (num <= max) {
            printData.send(num);
            num++;
        }
    }
}
