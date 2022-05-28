package interview.exception;

public class MyException {

    private static void test() throws Exception {
        try {
            System.out.println("Execute try block");
            throw new Exception();
        } finally {
            System.out.println("Execute finally block");
        }
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}
