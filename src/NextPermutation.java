
import java.util.Arrays;

public class NextPermutation {

    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        int mx = 0;
        int idx = n - 1;
        while (idx >= 0 && nums[idx] >= mx) {
            mx = Math.max(mx, nums[idx]);
            idx--;
        }
        if (idx < 0) {
            Arrays.sort(nums);
        } else {
            int target = mx;
            int tIdx = 0;
            for (int i = idx + 1; i < n; i++) {
                if (nums[i] > nums[idx]) {
                    if (nums[i] <= target) {
                        tIdx = i;
                        target = nums[i];
                    }
                }
            }
            int temp = nums[tIdx];
            nums[tIdx] = nums[idx];
            nums[idx] = temp;
            Arrays.sort(nums, idx + 1, n);
        }
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
