package exception;

public class TestClass {

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Execute try block");
            throw new Exception();
        } finally {
            System.out.println("Execute finally block");
        }
    }
}
