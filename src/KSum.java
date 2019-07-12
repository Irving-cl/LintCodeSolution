
public class KSum {

    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        int n = A.length;
        int[][] dp = new int[k + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(i + 1, k); j > 0; j--) {
                for (int t = target; t > 0; t--) {
                    if (t >= A[i]) {
                        dp[j][t] += dp[j - 1][t - A[i]];
                    }
                }
            }
        }
        return dp[k][target];
    }

    public static void main(String[] args) {

    }
}