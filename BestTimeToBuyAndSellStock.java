
public class BestTimeToBuyAndSellStock {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length == 0) {
            return res;
        }
        int lo = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > lo) {
                res = Math.max(res, prices[i] - lo);
            } else {
                lo = Math.min(lo, prices[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}