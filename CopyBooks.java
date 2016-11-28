
public class CopyBooks {

    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        int n = pages.length;
        if (k >= n) {
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) ans = Math.max(ans, pages[i]);
            return ans;
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            pages[i] += pages[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = pages[i - 1];
                for (int t = 1; t < i; t++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[t][j - 1], pages[i - 1] - pages[t - 1]));
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {

    }
}