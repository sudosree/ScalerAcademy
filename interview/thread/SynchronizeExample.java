package interview.thread;

public class SynchronizeExample {

    public static void main(String[] args) {
        SynchronizeThread st = new SynchronizeThread();
        Thread thread1 = new Thread(st);
        thread1.start();
        System.out.println(st.getSum());
        Thread thread2 = new Thread(st);
        thread2.start();
        System.out.println(st.getSum());
        Thread thread3 = new Thread(st);
        thread3.start();
        System.out.println(st.getSum());
    }
}
