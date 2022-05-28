package interview.thread.evenodd;

public class Odd implements Runnable {
    private int max;
    private Printer printer;

    public Odd(int max, Printer printer) {
        this.max = max;
        this.printer = printer;
    }

    @Override
    public void run() {
        int num = 1;
        while (num <= max) {
            printer.printOdd(num);
            num += 2;
        }
    }
}
