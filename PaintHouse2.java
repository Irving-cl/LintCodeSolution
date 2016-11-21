
public class PaintHouse2 {

    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        int[] dp = new int[k];
        for (int i = 0; i < k; i++) {
            dp[i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            int[] left = new int[k];
            int[] right = new int[k];
            for (int j = 0; j < k; j++) {
                left[j] = right[j] = Integer.MAX_VALUE;
            }
            for (int j = 1; j < k; j++) {
                left[j] = Math.min(left[j - 1], dp[j - 1]);
                right[k - 1 - j] = Math.min(right[k - j], dp[k - j]);
            }
            for (int j = 0; j < k; j++) {
                dp[j] = Math.min(left[j], right[j]) + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}