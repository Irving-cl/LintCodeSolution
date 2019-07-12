
public class MinimumSizeSubarraySum {

    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int n = nums.length;
        int[] pfs = new int[n + 1];
        pfs[0] = 0;
        for (int i = 1; i <= n; i++) {
            pfs[i] = pfs[i - 1] + nums[i - 1];
        }
        int i = 0;
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            while (i < j && pfs[j] - pfs[i] >= s) {
                ans = Math.min(ans, j - i);
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

    }
}
