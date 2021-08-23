package interview.thread;

public class SynchronizeThread implements Runnable {

    private int sum = 5;

    @Override
    public void run() {
        setSum();
    }

    private synchronized void setSum() {
        sum = sum + 10;
    }

    public int getSum() {
        return sum;
    }
}
