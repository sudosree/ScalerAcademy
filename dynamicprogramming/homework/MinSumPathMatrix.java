package dynamicprogramming.homework;

import java.util.Arrays;

public class MinSumPathMatrix {

    public int minPathSum(int[][] A) {
        int m = A.length, n = A[0].length;
        return minPathSumHelper(A, m-1, n-1);
    }

    private int minPathSumHelper(int[][] A, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return A[i][j];
        }
        // any cell in first row is reachable only from its left cell
        if (i == 0) {
            return A[0][j] + minPathSumHelper(A, 0, j-1);
        }
        // any cell in first column is reachable only from its top cell
        if (j == 0) {
            return A[i][0] + minPathSumHelper(A, i-1, 0);
        }

        // for the remaining cells , it is reachable from its left or top cell
        // but we have to consider the minimum among them
        return A[i][j] + Math.min(minPathSumHelper(A, i, j-1), minPathSumHelper(A,i-1, j));
    }

    private int[][] minSumPath;

    public int minPathSumMemo(int[][] A) {
        int m = A.length, n = A[0].length;
        minSumPath = new int[m][n];
        for (int i=0;i<m;i++) {
            Arrays.fill(minSumPath[i], Integer.MAX_VALUE);
        }
        return minPathSumHelperMemo(A, m-1, n-1);
    }

    private int minPathSumHelperMemo(int[][] A, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return A[i][j];
        }
        // any cell in first row is reachable only from its left cell
        if (i == 0) {
            return A[0][j] + minPathSumHelperMemo(A, 0, j-1);
        }
        // any cell in first column is reachable only from its top cell
        if (j == 0) {
            return A[i][0] + minPathSumHelperMemo(A, i-1, 0);
        }

        if (minSumPath[i][j] != Integer.MAX_VALUE) {
            return minSumPath[i][j];
        }

        // for the remaining cells , it is reachable from its left or top cell
        // but we have to consider the minimum among them
        minSumPath[i][j] = A[i][j] + Math.min(minPathSumHelperMemo(A, i, j-1), minPathSumHelperMemo(A,i-1, j));
        return minSumPath[i][j];
    }

    /**
     * TC = O(m*n), SC = O(1)
     * @param A
     * @return
     */
    public int minPathSumDP(int[][] A) {
        int m = A.length, n = A[0].length;
        // for first row
        for (int i=1;i<n;i++) {
            A[0][i] += A[0][i-1];
        }
        // for first column
        for (int i=1;i<m;i++) {
            A[i][0] += A[i-1][0];
        }
        // for any other cells
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                A[i][j] += Math.min(A[i][j-1], A[i-1][j]);
            }
        }
        return A[m-1][n-1];
    }
}
