
public class MaximumSubarray3 {

    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                dp[j][i] = Integer.MIN_VALUE;
                int mx = Integer.MIN_VALUE;
                int local = 0;
                for (int t = j - 1; t >= i - 1; t--) {
                    local = Math.max(nums[t], nums[t] + local);
                    mx = Math.max(mx, local);
                    dp[j][i] = Math.max(dp[j][i], dp[t][i - 1] + mx);
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {

    }
}