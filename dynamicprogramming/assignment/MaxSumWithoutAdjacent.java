package dynamicprogramming.assignment;

public class MaxSumWithoutAdjacent {

    public int adjacent(int[][] A) {
        int n = A[0].length;
        int[] B = new int[n];
        for (int i=0;i<n;i++) {
            B[i] = Math.max(A[0][i], A[1][i]);
        }
        return maxSum(B, n);
    }

    /**
     * TC = O(n), SC = O(n)
     * @param B
     * @param n
     * @return
     */
    private int maxSum(int[] B, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return B[0];
        }
        if (n == 2) {
            return Math.max(B[0], B[1]);
        }
        int[] sum = new int[n+1];
        sum[1] = B[0];
        sum[2] = Math.max(B[0], B[1]);
        for (int i=3;i<n+1;i++) {
            sum[i] = Math.max(B[i-1] + sum[i-2], sum[i-1]);
        }
        return sum[n];
    }
}
