
public class PalindromePartitioning2 {

    boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (valid(s, j, i)) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}

