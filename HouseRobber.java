
public class HouseRobber {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return A[0];
        }
        long[] dp = new long[3];
        dp[0] = 0;
        dp[1] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[2] = Math.max(dp[0] + A[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

    public static void main(String[] args) {

    }
}

