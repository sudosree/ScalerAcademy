package dynamicprogramming.homework;

public class MaximumSum {

    /**
     * TC = O(n), SC = O(n)
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int solve(int[] A, int B, int C, int D) {
        int n = A.length;
        int[][] dp = new int[n][3];
        dp[0][0] = A[0] * B;
        dp[0][1] = dp[0][0] + A[0] * C;
        dp[0][2] = dp[0][1] + A[0] * D;

        for (int i=1;i<n;i++) {
            // for A[i] * B
            dp[i][0] = Math.max(dp[i-1][0], A[i] * B);
            // for A[i] * B + A[j] * C
            dp[i][1] = Math.max(dp[i-1][1], dp[i][0] + A[i] * C);
            // for A[i] * B + A[j] * C + A[k] * D
            dp[i][2] = Math.max(dp[i-1][2], dp[i][1] + A[i] * D);
        }
        return dp[n-1][2];
    }
}
