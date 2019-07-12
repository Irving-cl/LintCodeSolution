
public class DecodeWays {

    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        int[] dp = new int[3];
        dp[0] = 1;
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        if (n < 2) {
            return dp[1];
        }
        for (int i = 1; i < n; i++) {
            dp[2] = 0;
            int digit = s.charAt(i) - '0';
            int lastDigit = s.charAt(i - 1) - '0';
            if (digit > 0) {
                dp[2] += dp[1];
            }
            if (lastDigit != 0) {
                int num = digit + lastDigit * 10;
                if (num < 27) {
                    dp[2] += dp[0];
                }
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

    public static void main(String[] args) {

    }
}