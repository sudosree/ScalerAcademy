package queue.assignment;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {

    static class CustomException extends Exception {
        CustomException() {
            super("Custom Exception");
        }
    }

    void check() throws CustomException {
        System.out.println("check");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.check();
    }
}
