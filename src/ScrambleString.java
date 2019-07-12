
public class ScrambleString {

    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        if (len1 == 0) {
            return true;
        }
        boolean[][][] dp = new boolean[len1][len1][len1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len1; j++) {
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int k = 1; k < len1; k++) {
            for (int i = 0; i + k < len1; i++) {
                for (int j = 0; j + k < len1; j++) {
                    dp[i][j][k] = (dp[i][j][(k-1)/2] && dp[i+(k+1)/2][j+(k+1)/2][k/2]) ||
                            (dp[i][j][k/2] && dp[i+k/2+1][j+k/2+1][(k-1)/2]) ||
                            (dp[i][j+k/2+1][(k-1)/2] && dp[i+(k+1)/2][j][k/2]) ||
                            (dp[i][j+(k+1)/2][k/2] && dp[i+k/2+1][j][(k-1)/2]);
                }
            }
        }
        return dp[0][0][len1 - 1];
    }

    public static void main(String[] args) {

    }
}