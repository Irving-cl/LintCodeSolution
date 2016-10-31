
public class Backpack {

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int[] dp = new int[m + 1];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j], A[i] + dp[j - A[i]]);
                }
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {

    }
}
