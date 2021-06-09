package dynamicprogramming.practice;

import java.util.Arrays;

public class CoinSumInfiniteOrderDoesnotMatters {

    private static int totalWays(int[] coins, int amount) {
        return totalWaysHelper(coins, amount, 0);
    }

    private static int totalWaysHelper(int[] coins, int amount, int currIndex) {
        // reached a solution
        if (amount == 0) {
            return 1;
        }
        // all coins are exhausted, so there is no way to form the sum
        if (currIndex == coins.length) {
            return 0;
        }
        int count = 0;
        // include the coin if the current denomination is less or equal to the sum
        // after including the coin we have to form the remaining sum (amount - coins[currIndex])
        // including the current coin as we have unlimited supply of coins
        if (coins[currIndex] <= amount) {
            count += totalWaysHelper(coins, amount - coins[currIndex], currIndex);
        }
        // do not include the coin
        count += totalWaysHelper(coins, amount, currIndex+1);
        return count;
    }

    private static int[][] dp;

    /**
     * TC = O(n * N) (where N = amount, n = no. of coins)
     * SC = O(n * N)
     */
    private static int totalWaysM(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        for (int i=0;i<coins.length+1;i++) {
            Arrays.fill(dp[i], -1);
        }
        return totalWaysMHelper(coins, amount, 1);
    }

    private static int totalWaysMHelper(int[] coins, int amount, int currIndex) {
        // reached one solution
        if (amount == 0) {
            return 1;
        }
        // exhausted all the coins
        if (currIndex == coins.length+1) {
            return 0;
        }
        // already computed this state
        if (dp[currIndex][amount] != -1) {
            return dp[currIndex][amount];
        }

        // include the coin
        int select = 0;
        if (coins[currIndex-1] <= amount) {
            select = totalWaysMHelper(coins, amount - coins[currIndex-1], currIndex);
        }
        // exclude the coin
        int reject = totalWaysMHelper(coins, amount, currIndex+1);
        dp[currIndex][amount] = select + reject;
        return dp[currIndex][amount];
    }

    /**
     * TC = O(n * N) (where N = amount, n = no. of coins)
     * SC = O(n * N)
     */
    private static int totalWaysDP(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i=1; i<coins.length+1; i++) {
            // if the sum is zero then you have reach a solution
            dp[i][0] = 1;
            for (int j=1; j<amount+1; j++) {
                // include the coin
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j - coins[i-1]];
                }
                // exclude the coin
                dp[i][j] += dp[i-1][j];
            }
        }
        return dp[coins.length][amount];
    }

    /**
     * TC = O(n * N) (where N = amount, n = no. of coins)
     * SC = O(N)
     */
    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // base case
        dp[0] = 1;
        for (int i=0;i<coins.length;i++) {
            // where j is the amount
            for (int j=coins[i]; j<amount+1; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] A = {1,3,4};
        int S = 5;
        System.out.println(totalWays(A, S));
        System.out.println(totalWaysM(A, S));
        System.out.println(totalWaysDP(A, S));
        System.out.println(coinChange(A, S));
    }
}
