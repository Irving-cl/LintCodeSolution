
public class HouseRobber2 {

    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[2] = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        int res = dp[2];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[2] = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        res = Math.max(res, dp[2]);
        return res;
    }

    public static void main(String[] args) {

    }
}
