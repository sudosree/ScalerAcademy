package BitManipulation.practice;

public class TrailingZeroes
{
    private static int solve(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) == 0) {
                count++;
            }
            if ((A & 1) == 1) {
                break;
            }
            A >>= 1;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int A = 8;
        System.out.println(solve(A));
    }
}
