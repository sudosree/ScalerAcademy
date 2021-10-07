package dynamicprogramming.practice;

import java.util.Arrays;

public class CoinChange {

    /**
     * TC = O(S^N), SC = O(N)
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        return coinChangeHelper(coins, amount);
    }

    private static int coinChangeHelper(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int minCount = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++) {
            int count = coinChangeHelper(coins, amount - coins[i]);
            if (count == -1) {
                continue;
            }
            minCount = Math.min(minCount, 1 + count);
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private static int[] memo;

    /**
     * TC = O(S * N), SC = O(S)
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange1(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return coinChangeHelper1(coins, amount);
    }

    private static int coinChangeHelper1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }
        int minCount = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++) {
            int count = coinChangeHelper(coins, amount - coins[i]);
            if (count == -1) {
                continue;
            }
            minCount = Math.min(minCount, 1 + count);
        }
        minCount = minCount == Integer.MAX_VALUE ? -1 : minCount;
        memo[amount] = minCount;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
