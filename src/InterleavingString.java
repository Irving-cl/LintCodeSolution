
public class InterleavingString {

    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int tot = s3.length();
        if (m + n != tot) {
            return false;
        }
        if (tot == 0) {
            return true;
        }
        if (m == 0 && s2.compareTo(s3) != 0) {
            return false;
        }
        if (n == 0 && s1.compareTo(s3) != 0) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0) dp[i][j] |= (dp[i - 1][j] & s3.charAt(i + j - 1) == s1.charAt(i - 1));
                if (j > 0) dp[i][j] |= (dp[i][j - 1] & s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
