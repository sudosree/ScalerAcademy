package dynamicprogramming.practice;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }

    private int minCost(int[] cost, int n) {
        if (n < 0) {
            return 0;
        }
        // min cost to reach the step 0 or step 1 is the cost itself
        if (n == 0 || n == 1) {
            return cost[n];
        }
        return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return Math.min(dp[n-2], dp[n-1]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev1 = cost[1];
        int prev2 = cost[0];
        for (int i=2; i<n; i++) {
            int minCost = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = minCost;
        }
        return Math.min(prev1, prev2);
    }

    private int[] minCost;

    public int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        minCost = new int[n];
        Arrays.fill(minCost, -1);
        return Math.min(minCost1(cost, n-1), minCost1(cost, n-2));
    }

    private int minCost1(int[] cost, int n) {
        if (n < 0) {
            return 0;
        }
        // min cost to reach the step 0 or step 1 is the cost itself
        if (n == 0 || n == 1) {
            return cost[n];
        }
        if (minCost[n] != -1) {
            return minCost[n];
        }
        minCost[n] = cost[n] + Math.min(minCost1(cost, n-1), minCost1(cost, n-2));
        return minCost[n];
    }
}
