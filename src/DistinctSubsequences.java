
public class DistinctSubsequences {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        int s = S.length();
        int t = T.length();
        int[][] dp = new int[s + 1][t + 1];
        for (int i = 0; i <= s; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= t; j++) {
            for (int i = t; i <= s; i++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s][t];
    }

    public static void main(String[] args) {

    }
}

