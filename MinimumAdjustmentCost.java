
import java.util.ArrayList;

public class MinimumAdjustmentCost {

    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int[][] dp = new int[A.size() + 1][101];
        for (int i = 1; i <= A.size(); i++) {
            for (int j = 0; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= A.size(); i++) {
            for (int j = 1; j <= 100; j++) {
                for (int k = 1; k <= 100; k++) {
                    if (Math.abs(j - k) <= target) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i - 1) - j));
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            res = Math.min(res, dp[A.size()][i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

