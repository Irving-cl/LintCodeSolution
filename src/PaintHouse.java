
public class PaintHouse {

    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        int rIdx = 1;
        int other[][] = { {1, 2}, {0, 2}, {0, 1}};
        for (int i = 1; i < costs.length; i++, rIdx = 1 - rIdx) {
            for (int j = 0; j < 3; j++) {
                int o1 = other[j][0];
                int o2 = other[j][1];
                dp[rIdx][j] = Math.min(dp[1 - rIdx][o1], dp[1 - rIdx][o2]) + costs[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[1 - rIdx][i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

