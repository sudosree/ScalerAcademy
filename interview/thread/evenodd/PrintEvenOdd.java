package interview.thread.evenodd;

public class PrintEvenOdd {

    public static void main(String[] args) {
        Printer printer = new Printer();
//        TaskEvenOdd odd = new TaskEvenOdd(printer, 10, false);
//        TaskEvenOdd even = new TaskEvenOdd(printer, 10, true);

        Odd odd = new Odd(10, printer);
        Even even = new Even(10, printer);

        Thread oddThread = new Thread(odd, "Odd");
        Thread evenThread = new Thread(even, "Even");
        oddThread.start();
        evenThread.start();
    }
}
