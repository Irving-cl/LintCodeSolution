
import java.util.Arrays;

public class Median {

    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length % 2 == 0 ? (nums.length / 2 - 1) : (nums.length / 2);
        return nums[mid];
    }

    public static void main(String[] args) {

    }
}
