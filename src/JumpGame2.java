
public class JumpGame2 {

    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        int[] dp = new int[A.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j <= Math.min(A.length - 1, i + A[i]); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {

    }
}

