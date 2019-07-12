
public class Triangle {

    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null) {
            return 0;
        }
        int n = triangle.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[2][n];
        int rIdx = 0;
        dp[rIdx][0] = triangle[0][0];
        rIdx = 1 - rIdx;
        for (int i = 1; i < n; i++, rIdx = 1 - rIdx) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[rIdx][j] = dp[1 - rIdx][j] + triangle[i][j];
                } else if (j == i) {
                    dp[rIdx][j] = dp[1 - rIdx][j - 1] + triangle[i][j];
                } else {
                    dp[rIdx][j] = Math.min(dp[1 - rIdx][j - 1], dp[1 - rIdx][j]) + triangle[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[1 - rIdx][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
};