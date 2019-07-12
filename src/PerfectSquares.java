
public class PerfectSquares {

    public int sqrt(int i) {
        int j = 1;
        while (j * j <= i) {
            j++;
        }
        return j - 1;
    }

    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int sqrtI = sqrt(i);
            if (sqrtI * sqrtI == i) {
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j * j < i; j++) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
