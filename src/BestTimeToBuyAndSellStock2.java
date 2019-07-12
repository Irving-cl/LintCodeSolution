
public class BestTimeToBuyAndSellStock2 {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int mp = 0;
        int last = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > last) {
                mp += prices[i] - last;
            }
            last = prices[i];
        }
        return mp;
    }

    public static void main(String[] args) {
        
    }
}