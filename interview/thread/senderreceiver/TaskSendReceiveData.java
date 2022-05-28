package interview.thread.senderreceiver;

public class TaskSendReceiveData implements Runnable {
    private int max;
    private PrintData printData;
    private boolean sender;

    public TaskSendReceiveData(int max, PrintData printData, boolean sender) {
        this.max = max;
        this.printData = printData;
        this.sender = sender;
    }

    @Override
    public void run() {
        int num = 1;
        while (num <= max) {
            if (sender) {
                printData.send(num);
            } else {
                printData.receive(num);
            }
            num++;
        }
    }
}
