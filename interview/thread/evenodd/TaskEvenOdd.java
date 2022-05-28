package interview.thread.evenodd;

public class TaskEvenOdd implements Runnable {

    private int max;
    private boolean isEvenNo;
    private Printer printer;

    public TaskEvenOdd(Printer printer, int max, boolean isEvenNo) {
        this.printer = printer;
        this.max = max;
        this.isEvenNo = isEvenNo;
    }

    @Override
    public void run() {
        int number = isEvenNo ? 2 : 1;
        while (number <= max) {
            if (isEvenNo) {
                printer.printEven(number);
            } else {
                printer.printOdd(number);
            }
            number += 2;
        }
    }
}
