
import java.util.Arrays;

public class NextPermutation2 {

    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        for (int i = nums.length - 2; i >= 0 && !flag; i--) {
            if (nums[i] < nums[i + 1]) {
                int idx = i + 1;
                while (idx < nums.length - 1 && nums[idx + 1] > nums[i]) {
                    idx++;
                }
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                    l++;
                    r--;
                }
                flag = true;
            }
        }
        if (!flag) {
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {

    }
}

