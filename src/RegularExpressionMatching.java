
public class RegularExpressionMatching {

    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = (p.charAt(i - 1) == '*' && dp[0][i - 1]);
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1];
                } else {
                    boolean match = (s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.');
                    dp[i + 1][j + 1] = dp[i][j] && match;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}