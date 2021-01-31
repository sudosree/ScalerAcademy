package maths.assignment;

public class FindNthMagicNumber
{
    private static int solve(int A) {
        int pow = 1, ans = 0;
        while (A > 0) {
            pow *= 5;
            // if the last bit is set then it is a odd number then sum up
            // else the last bit is zero that means it is an even number
            if ((A & 1) == 1) {
                ans += pow;
            }
            A >>= 1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int A = 3;
        System.out.println(solve(A));
    }
}
