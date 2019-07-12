
public class MaximumSubArray {

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
