
import java.util.Set;

public class WordBreak {

    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            dp[i] = false;
        }
        for (int i = 0; i < len; i++) {
            for (String str : dict) {
                int len1 = str.length();
                if (i + 1 >= len1 && dp[i + 1 - len1] &&
                    s.substring(i + 1 - len1, i + 1).compareTo(str) == 0) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {

    }
}