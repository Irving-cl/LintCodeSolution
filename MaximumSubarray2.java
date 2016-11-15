
import java.util.ArrayList;

public class MaximumSubarray2 {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];
        if (n == 0) {
            return 0;
        }
        int sum = left[0];
        left[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            if (sum < 0) {
                sum = nums.get(i);
            } else {
                sum += nums.get(i);
            }
            left[i] = Math.max(left[i], left[i - 1]);
        }
        sum = right[n - 1];
        right[n - 1] = nums.get(n - 1);
        for (int i = n - 1; i >= 0; i++) {
            if (sum < 0) {
                sum = nums.get(i);
            } else {
                sum += nums.get(i);
            }
            right[i] = Math.max(right[i], right[i + 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, left[i - 1] + right[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}