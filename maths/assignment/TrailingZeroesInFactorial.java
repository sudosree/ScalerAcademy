package maths.assignment;

public class TrailingZeroesInFactorial
{
    private static int solve(int A) {
        int count = 0;
        while (A > 0) {
            A /= 5;
            count += A;
        }
        return count;
    }

    private static int solve1(int A) {
        int count = 0;
        int pow = 1;
        int temp = A;
        while (temp > 1) {
            pow = pow * 5;
            temp = A/pow;
            count += temp;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int A = 125;
        System.out.println(solve1(A));
    }
}
