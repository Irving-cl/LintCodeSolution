
public class BackPack2 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (m == 0) {
            return 0;
        }
        int dp[] = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int v = m; v >= 0; v--) {
                if (v >= A[i]) {
                    dp[v] = Math.max(dp[v], dp[v - A[i]] + V[i]);
                }
            }
        }
        return dp[m];
    }
}

