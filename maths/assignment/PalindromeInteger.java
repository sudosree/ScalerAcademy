package maths.assignment;

public class PalindromeInteger
{
    private static int solve(int A) {
        int rev = 0;
        int temp = A;
        while (temp > 0) {
            int digit = temp%10;
            rev = rev * 10 + digit;
            temp /= 10;
        }
        return A == rev ? 1 : 0;
    }

    public static void main(String[] args)
    {
        int A = 12321;
        System.out.println(solve(A));
    }
}
