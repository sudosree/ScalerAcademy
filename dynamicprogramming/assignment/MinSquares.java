package dynamicprogramming.assignment;

import java.util.Arrays;

public class MinSquares {

    /**
     * TC = O(2^A), SC = O(2^A)
     * @param A
     * @return
     */
    public int countMinSquares(int A) {
        if (A <= 1) {
            return A;
        }
        int ans = A;
        for (int i=1;i*i<=A;i++) {
            ans = Math.min(ans, countMinSquares(A - i*i) + 1);
        }
        return ans;
    }

    /**
     * TC = O(n * sqrt(n)), SC = O(n)
     * @param A
     * @return
     */
    public static int countMinSquares1(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i=1;i<A+1;i++) {
            dp[i] = i;
            for (int j=1;j*j<=i;j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[A];
    }

    private int[] dp;

    public int countMinSquares2(int A) {
        dp = new int[A+1];
        Arrays.fill(dp, -1);
        return countMinSquaresHelper(A);
    }

    /**
     * TC = O(n * sqrt(n)), SC = O(n)
     * @return
     */
    private int countMinSquaresHelper(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] >= 0) {
            return dp[n];
        }
        dp[n] = n;
        for (int i=1;i*i<=n;i++) {
            dp[n] = Math.min(dp[n], countMinSquaresHelper(n-i*i) + 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countMinSquares1(12));
    }
}
