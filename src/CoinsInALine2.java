
public class CoinsInALine2 {

    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        if (n <= 2) {
            return true;
        }
        int[] sum = new int[n + 1];
        sum[n] = values[n - 1];
        for (int i = n - 1; i > 0; i--) {
            sum[i] = sum[i + 1] + values[i - 1];
        }
        int[] dp = new int[n];
        dp[n - 1] = sum[n];
        dp[n - 2] = sum[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(sum[i + 1] - dp[i + 1], sum[i + 1] - dp[i + 2]);
        }
        return (dp[0] * 2) > sum[1];
    }

    public static void main(String[] args) {

    }
}

