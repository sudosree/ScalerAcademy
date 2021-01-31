package maths.practice;

public class FindGCD
{
    private static int findGCD(int A, int B) {
        if (A == 0) {
            return B;
        }
        if (B == 0) {
            return A;
        }
        // A will always be greater or equal to B
        if (B > A) {
            int t = A;
            A = B;
            B = t;
        }
        int diff = A-B;
        while (diff != 0) {
            if (diff > B) {
                A = diff;
            } else {
                A = B;
                B = diff;
            }
            diff = A - B;
        }
        return A;
    }

    public static void main(String[] args)
    {
        int A = 28, B = 9;
        System.out.println(findGCD(A,B));
    }
}
