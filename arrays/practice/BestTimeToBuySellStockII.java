package arrays.practice;

public class BestTimeToBuySellStockII {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int buy = 0, sell = 0;
        int i = 0;

        while (i < n-1) {
            // find valley
            while (i < n-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            buy = prices[i];
            // find peak
            while (i < n-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            sell = prices[i];
            maxProfit += sell - buy;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
