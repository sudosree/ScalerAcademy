package interview.thread.evenodd;

public class Even implements Runnable {
    private int max;
    private Printer printer;

    public Even(int max, Printer printer) {
        this.max = max;
        this.printer = printer;
    }

    @Override
    public void run() {
        int num = 2;
        while (num <= max) {
            printer.printEven(num);
            num += 2;
        }
    }
}
