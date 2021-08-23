package dynamicprogramming.practice;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        return coinChangeHelper(coins, amount, 0);
    }

    private static int coinChangeHelper(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 0;
        }
        if (index == coins.length) {
            return 0;
        }
        int select = 0;
        // select the coin
        if (coins[index] <= amount) {
            select = 1 + coinChangeHelper(coins, amount - coins[index], index);
        }
        // reject the coin
        int reject = coinChangeHelper(coins, amount, index + 1);
        return Math.min(select, reject);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
