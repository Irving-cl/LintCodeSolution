
public class BurstBalloons {

    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] n = new int[len];
        int[][] dp = new int[len][len];
        n[0] = n[len - 1] = 1;
        for (int i = 1; i < len - 1; i++) {
            n[i] = nums[i - 1];
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = 0;
        }
        for (int s = 2; s < len; s++) {
            for (int i = 0; i + s < len; i++) {
                int j = i + s;
                dp[i][j] = 0;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + n[i]*n[k]*n[j]);
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {

    }
}