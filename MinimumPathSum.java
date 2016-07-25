
public class MinimumPathSum {

    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];
        int rIdx = 0;
        dp[rIdx][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[rIdx][i] = dp[rIdx][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            rIdx = 1 - rIdx;
            dp[rIdx][0] = dp[1 - rIdx][0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[rIdx][j] = Math.min(dp[rIdx][j - 1], dp[1 - rIdx][j]) + grid[i][j];
            }
        }
        return dp[rIdx][n - 1];
    }

    public static void main(String[] args) {

    }
}
