package dynamicprogramming.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathInTriangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        return minimumTotalHelper(a, 0, 0);
    }

    private int minimumTotalHelper(ArrayList<ArrayList<Integer>> a, int i, int j) {
        // base case
        if (i == a.size()-1) {
            return a.get(i).get(j);
        }
        // consider jth value in (i+1)th row
        int minSum1 = minimumTotalHelper(a, i+1, j);
        // consider (j+1)th value in (i+1)th row
        int minSum2 = minimumTotalHelper(a, i+1, j+1);
        return Math.min(a.get(i).get(j) + minSum1, a.get(i).get(j) + minSum2);
    }

    private int[][] dp;

    public int minimumTotalMemo(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        dp = new int[n][];
        for (int i=0;i<n;i++) {
            dp[i] = new int[a.get(i).size()];
            Arrays.fill(dp[i], -1);
        }
        return minimumTotalMemoHelper(a, 0, 0);
    }

    private int minimumTotalMemoHelper(ArrayList<ArrayList<Integer>> a, int i, int j) {
        // base case
        if (i == a.size()-1) {
            return a.get(i).get(j);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // consider jth value in (i+1)th row
        int minSum1 = minimumTotalMemoHelper(a, i+1, j);
        // consider (j+1)th value in (i+1)th row
        int minSum2 = minimumTotalMemoHelper(a, i+1, j+1);
        dp[i][j] = Math.min(a.get(i).get(j) + minSum1, a.get(i).get(j) + minSum2);
        return dp[i][j];
    }

    public int minimumTotalDP(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int m = a.get(n-1).size();
        int[][] minSumPath = new int[n][m];
        for (int i=0;i<m;i++) {
            minSumPath[n-1][i] = a.get(n-1).get(i);
        }
        for (int i=n-2;i>=0;i--) {
            m = a.get(i).size();
            for (int j=0;j<m;j++) {
                minSumPath[i][j] = Math.min(minSumPath[i+1][j], minSumPath[i+1][j+1]) + a.get(i).get(j);
            }
        }
        return minSumPath[0][0];
    }

    public int minimumTotalDP1(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int[] minSumPath = new int[n];
        for (int i=0;i<n;i++) {
            minSumPath[i] = a.get(n-1).get(i);
        }
        for (int i=n-2;i>=0;i--) {
            for (int j=0;j<=i;j++) {
                minSumPath[j] = Math.min(minSumPath[j], minSumPath[j+1]) + a.get(i).get(j);
            }
        }
        return minSumPath[0];
    }
}
