package recursion.homework;

public class AnotherSequence
{
    private static int solve(int A) {
        if (A == 0 || A == 1) {
            return 1;
        }
        if (A == 2) {
            return 2;
        }
        return solve(A-1) + solve(A-2) + solve(A-3) + A;
    }

    public static void main(String[] args)
    {
        int A = 2;
        System.out.println(solve(A));
    }
}
