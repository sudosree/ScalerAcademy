package recursion.homework;

public class SumOfDigits
{
    private static int solve(int A) {
        if (A >= 1 && A <= 9) {
            return A;
        }
        return solve(A/10) + A%10;
    }

    public static void main(String[] args)
    {
        int A = 796;
        System.out.println(solve(A));
    }
}
