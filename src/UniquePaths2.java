
public class UniquePaths2 {

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int dp[][] = new int[2][n];
        int rIdx = 0;
        dp[rIdx][0] = obstacleGrid[0][0] == 1 ? 0 : dp[1 - rIdx][0];
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[rIdx][i] = 0;
            } else {
                dp[rIdx][i] = dp[rIdx][i - 1];
            }
        }
        rIdx = 1 - rIdx;
        for (int i = 1; i < m; i++, rIdx = 1 - rIdx) {
            dp[rIdx][0] = obstacleGrid[i][0] == 1 ? 0 : 1;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[rIdx][j] = 0;
                } else {
                    dp[rIdx][j] = dp[rIdx][j - 1] + dp[1 - rIdx][j];
                }
            }
        }
        return dp[1 - rIdx][n - 1];
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{ {0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(test));
    }
};