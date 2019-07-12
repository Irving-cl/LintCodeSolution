
public class BestTimeToBuyAndSellStock4 {

    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        k = Math.min(k, prices.length / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= Math.min(i + 1, k); j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }

    public static void main(String[] args) {

    }
}