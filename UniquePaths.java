
public class UniquePaths {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int dp[][] = new int[2][n];
        int rIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[rIdx][i] = 1;
        }
        rIdx = 1;
        for (int i = 1; i < m; i++, rIdx = 1 - rIdx) {
            dp[rIdx][0] = 1;
            for (int j = 1; j < n; j++) {
                dp[rIdx][j] = dp[rIdx][j - 1] + dp[1 - rIdx][j];
            }
        }
        return dp[1 - rIdx][n - 1];
    }

    public static void main(String[] args) {
        
    }
}
