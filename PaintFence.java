
public class PaintFence {

    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public static int numWays(int n, int k) {
        int[] dp = { 0, k , k * k, 0 };
        if (n <= 2) {
            return dp[n];
        }
        for (int i = 2; i < n; i++) {
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }

    public static void main(String[] args) {
        System.out.println(numWays(3, 3));
    }
}
