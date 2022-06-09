package lc;

public class BestTimeBuyAndSellStock {

    // Time = O(N)
    // Space = O(1)
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int maxProfit = 0, buy = prices[0], sell = prices[1];
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                maxProfit = Math.max(maxProfit, sell - buy);
                buy = prices[i];
                sell = prices[i];
            } else if (prices[i] > sell) {
                sell = prices[i];
            }
            maxProfit = Math.max(maxProfit, sell - buy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeBuyAndSellStock bs = new BestTimeBuyAndSellStock();
        System.out.println("expected:2, actual: " + bs.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
        System.out.println("expected:2, actual: " + bs.maxProfit(new int[]{2, 4, 1}));
        System.out.println("expected:4, actual: " + bs.maxProfit(new int[]{1, 2, 3, 4, 5, 3, 5}));
        System.out.println("expected:5, actual: " + bs.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("expected:0, actual: " + bs.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println("expected:0, actual: " + bs.maxProfit(new int[]{1}));
    }
}
