package arrays.practice;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=0;i<prices.length;i++) {
            for (int j=i+1;j<prices.length;j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }
}
