package interview.thread.senderreceiver;

public class SendReceiveData {

    public static void main(String[] args) {
        PrintData data = new PrintData();

//        TaskSendReceiveData sender = new TaskSendReceiveData(10, data, true);
//        TaskSendReceiveData receiver = new TaskSendReceiveData(10, data, false);

        Sender sender = new Sender(10, data);
        Receiver receiver = new Receiver(10, data);

        Thread sT = new Thread(sender, "Sender");
        Thread rT = new Thread(receiver, "Receiver");

        sT.start();
        rT.start();
    }
}
