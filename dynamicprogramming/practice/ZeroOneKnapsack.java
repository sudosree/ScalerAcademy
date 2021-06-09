package dynamicprogramming.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroOneKnapsack {

    private static int maxProfit(int[] values, int[] weights, int W) {
        return maxProfitHelper(values, weights, W, 0);
    }

    private static int maxProfitHelper(int[] values, int[] weights, int W, int i) {
        // exhausted all the items
        if (i == values.length) {
            return 0;
        }
        // reached a solution
        if (W == 0) {
            return 0;
        }
        // select the item
        int select = 0;
        if (weights[i] <= W) {
            select = values[i] + maxProfitHelper(values, weights, W - weights[i], i+1);
        }
        // reject the item
        int reject = maxProfitHelper(values, weights, W, i+1);
        return Math.max(select, reject);
    }

    private static int[][] dp;

    /**
     * TC = O(n * W), SC = O(n * W) + O(n) (recursive stack space)
     */
    private static int maxProfitM(int[] values, int[] weights, int W) {
        dp = new int[values.length+1][W+1];
        for (int i=0; i< values.length+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxProfitMHelper(values, weights, W, 1);
    }

    private static int maxProfitMHelper(int[] values, int[] weights, int W, int i) {
        // exhausted all the items
        if (i == values.length+1) {
            return 0;
        }
        // reached a solution
        if (W == 0) {
            return 0;
        }
        if (dp[i][W] != -1) {
            return dp[i][W];
        }
        // select the item
        int select = 0;
        if (weights[i-1] <= W) {
            select = values[i-1] + maxProfitMHelper(values, weights, W - weights[i-1], i+1);
        }
        // reject the item
        int reject = maxProfitMHelper(values, weights, W, i+1);
        dp[i][W] = Math.max(select, reject);
        return dp[i][W];
    }

    /**
     * TC = O(n * W), SC = O(n * W)
     */
    private static int maxProfitDP(int[] values, int[] weights, int W) {
        int[][] dp = new int[values.length+1][W+1];
        for (int i=1; i<values.length+1; i++) {
            for (int j=1; j<W+1; j++) {
                // select the item
                int select = 0;
                if (weights[i-1] <= j) {
                    select = values[i-1] + dp[i-1][j - weights[i-1]];
                }
                // reject the item
                int reject = dp[i-1][j];
                dp[i][j] = Math.max(select, reject);
            }
        }
        return dp[values.length][W];
    }

    private static int maxProfitDP1(int[] values, int[] weights, int W) {
        int[] prev = new int[W+1];
        int[] curr = new int[W+1];
        for (int i=0; i<values.length; i++) {
            for (int j=1; j<W+1; j++) {
                // select the item
                int select = 0;
                if (weights[i] <= j) {
                    select = values[i] + prev[j - weights[i]];
                }
                // reject the item
                int reject = prev[j];
                curr[j] = Math.max(select, reject);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[W];
    }

    private static List<Integer> selectedItems(int[] values, int[] weights, int W) {
        int[][] dp = new int[values.length+1][W+1];
        for (int i=1; i<values.length+1; i++) {
            for (int j=1; j<W+1; j++) {
                int select = 0;
                if (weights[i-1] <= j) {
                    select = values[i-1] + dp[i-1][j - weights[i-1]];
                }
                int reject = dp[i-1][j];
                dp[i][j] = Math.max(select, reject);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int j = W;
        for (int i=values.length; i>0; i--) {
            // selected the item
            if (dp[i][j] != dp[i-1][j]) {
                ans.add(values[i-1]);
                j -= weights[i-1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        System.out.println(maxProfit(values, weights, W));
        System.out.println(maxProfitM(values, weights, W));
        System.out.println(maxProfitDP(values, weights, W));
        System.out.println(maxProfitDP1(values, weights, W));
        System.out.println(selectedItems(values, weights, W));
    }
}
