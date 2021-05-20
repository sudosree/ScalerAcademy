package dynamicprogramming.practice;

import java.util.Arrays;

public class MaxSumNonAdjacent {

    private static int maxSum(int[] A, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return A[0];
        }
        if (n == 2) {
            return Math.max(A[0], A[1]);
        }
        return Math.max(A[n-1] + maxSum(A, n-2), maxSum(A, n-1));
    }

    private static int[] sum;

    private static int solve(int[] A) {
        sum = new int[A.length + 1];
        Arrays.fill(sum, -1);
        return maxSum1(A, A.length);
    }

    private static int maxSum1(int[] A, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return A[0];
        }
        if (n == 2) {
            return Math.max(A[0], A[1]);
        }
        if (sum[n] >= 0) {
            return sum[n];
        }
        sum[n] = Math.max(A[n-1] + maxSum1(A, n-2), maxSum1(A, n-1));
        return sum[n];
    }

    /**
     * TC = O(n), SC = O(n)
     * @param A
     * @param n
     * @return
     */
    private static int maxSum2(int[] A, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return A[0];
        }
        if (n == 2) {
            return Math.max(A[0], A[1]);
        }
        int[] sum = new int[n+1];
        sum[1] = A[0];
        sum[2] = Math.max(A[0], A[1]);
        for (int i=3;i<n+1;i++) {
            sum[i] = Math.max(A[i-1] + sum[i-2], sum[i-1]);
        }
        return sum[n];
    }

    public static void main(String[] args) {
//        int[] A = {2,3,5,0,7,10};
        int[] A = { 12, 9, 7, 33 };
//        System.out.println(maxSum(A,A.length));
        System.out.println(maxSum2(A, A.length));
    }
}
