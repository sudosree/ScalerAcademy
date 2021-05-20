package dynamicprogramming.assignment;

public class ClimbStairs {

    /**
     * TC = O(2^n), SC = O(2^n)
     * @param A
     * @return
     */
    public int climbStairs(int A) {
        if (A <= 2) {
            return A;
        }
        return climbStairs(A-1) + climbStairs(A-2);
    }

    private int[] dp;

    public int climbStairs1(int A) {
        dp = new int[A+1];
        return climbStairsHelper(A);
    }

    /**
     * Memoization
     * TC = O(n), SC = O(n)
     * @param n
     * @return
     */
    private int climbStairsHelper(int n) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = climbStairsHelper(n-1) + climbStairsHelper(n-2);
        return dp[n];
    }

    /**
     * Bottom up
     * TC = O(n), SC = O(n)
     * @param A
     * @return
     */
    public int climbStairs2(int A) {
        if (A <= 2) {
            return A;
        }
        int[] dp = new int[A+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=A;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[A];
    }
}
