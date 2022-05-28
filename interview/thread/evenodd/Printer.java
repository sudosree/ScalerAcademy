package interview.thread.evenodd;

public class Printer {
    private boolean isOdd = true;

    public synchronized void printOdd(int num) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + num);
        isOdd = false;
        notify();
    }

    public synchronized void printEven(int num) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + num);
        isOdd = true;
        notify();
    }
}
