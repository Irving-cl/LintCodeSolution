
public class LongestPalindromicSubstring {

    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int len = s.length() * 2 + 1;
        char[] buf = new char[len];
        for (int i = 0; i < len; i++) buf[i] = '#';
        for (int i = 1; i < len; i += 2) buf[i] = s.charAt(i / 2);
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = 1;
        int maxLen = 1, maxIndex = 1, j = 1;
        for (int i = 2; i < len; i++) {
            int exBound = Math.min(i, len - i - 1);
            int exLen = dp[j] + j - i;
            if (2 * j >= i) {
                exLen = Math.min(dp[2 * j - i], dp[j] + j - i);
            }
            exLen = Math.max(0, exLen);
            while (exLen < exBound && buf[i + exLen + 1] == buf[i - exLen - 1]) { exLen++; }
            if (exLen > maxLen) {
                maxIndex = i;
                maxLen = exLen;
            }
            dp[i] = exLen;
            if (i + exLen > j + dp[j]) {
                j = i;
            }
        }
        char[] res = new char[maxLen];
        int midIdx = maxLen / 2;
        if (buf[maxIndex] == '#') {
            for (int i = 0; i < maxLen / 2; i++) {
                res[midIdx + i] = res[midIdx - 1 - i] = buf[maxIndex - i * 2 - 1];
            }
        } else {
            for (int i = 0; i < maxLen / 2 + 1; i++) {
                res[midIdx + i] = res[midIdx - i] = buf[maxIndex - i * 2];
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {

    }
}