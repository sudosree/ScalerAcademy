package dynamicprogramming.practice;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return helper(grid, 0, 0, m, n);
    }

    private int helper(int[][] grid, int i, int j, int m, int n) {
        if (i == m-1 && j == n-1) {
            return grid[i][j];
        }
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        int pathSum1 = helper(grid, i, j+1, m, n);
        int pathSum2 = helper(grid, i+1, j, m, n);
        return grid[i][j] + Math.min(pathSum1, pathSum2);
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // for the first row there is only one choice
        // each cell can only be reached from its left cell
        for (int i=1; i<n; i++) {
            grid[0][i] += grid[0][i-1];
        }

        // for the first column there is only one choice
        // each cell can only be reached from its up cell
        for (int i=1; i<m; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i=1; i<n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSum3(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] prev = new int[n];
        int[] curr = new int[n];
        prev[0] = grid[0][0];

        // first row
        for (int i=1; i<n; i++) {
            prev[i] = prev[i-1] + grid[0][i];
        }

        for (int i=1; i<m; i++) {
            curr[0] = prev[0] + grid[i][0];
            for (int j=1; j<n; j++) {
                curr[j] = grid[i][j] + Math.min(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return prev[n-1];
    }

    public int minPathSum4(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] curr = new int[n];
        curr[0] = grid[0][0];

        // first row
        for (int i=1; i<n; i++) {
            curr[i] = curr[i-1] + grid[0][i];
        }

        for (int i=1; i<m; i++) {
            curr[0] = curr[0] + grid[i][0];
            for (int j=1; j<n; j++) {
                curr[j] = grid[i][j] + Math.min(curr[j], curr[j-1]);
            }
        }
        return curr[n-1];
    }
}
