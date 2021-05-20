package dynamicprogramming.assignment;

public class UnboundedKnapsack {

    private static int solve(int[] profits, int[] weights, int C) {
        return findProfit(profits, weights, C, 0);
    }

    private static int findProfit(int[] profits, int[] weights, int C, int val) {
        if (C == 0) {
            return val;
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i=0;i<profits.length;i++) {
            if (weights[i] <= C) {
                int p = findProfit(profits, weights, C - weights[i], val + profits[i]);
                maxProfit = Math.max(maxProfit, p);
            }
        }
        return maxProfit;
    }

    private static int solve1(int[] profits, int[] weights, int C) {
        int[][] dp = new int[profits.length+1][C+1];
        for (int j=1;j<C+1;j++) {
            for (int i=1;i<profits.length+1;i++) {
                if (weights[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - weights[i-1]] + profits[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[profits.length][C];
    }

    private static int solve2(int[] profits, int[] weights, int C) {
        int[] dp = new int[C+1];
        for (int j=1;j<C+1;j++) {
            for (int i=0;i<profits.length;i++) {
                if (weights[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + profits[i]);
                }
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        int[] profits = {6,7};
        int[] weights = {5,5};
        System.out.println(solve(profits, weights, 10));
        System.out.println(solve1(profits, weights, 10));
    }
}
