
public class BestTimeToBuyAndSellStock3 {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int lo = prices[0];
        left[0] = 0;
        for (int i = 1; i < left.length; i++) {
            lo = Math.min(lo, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - lo);
        }
        int hi = prices[n - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            hi = Math.max(hi, prices[i]);
            right[i] = Math.max(right[i + 1], hi - prices[i]);
        }
        int ans = Math.max(left[n - 1], right[0]);
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(left[i] + right[i + 1], ans);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
