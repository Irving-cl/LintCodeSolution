
import java.util.Arrays;

public class WiggleSort {

    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] b = new int[nums.length / 2];
        int[] a = new int[nums.length - b.length];
        int lim = (nums.length & 1) == 0 ? nums.length / 2 : nums.length / 2 + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i < lim) {
                a[i] = nums[i];
            } else {
                b[i - a.length] = nums[i];
            }
        }
        int idxA = 0;
        int idxB = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = a[idxA++];
            } else {
                nums[i] = b[idxB++];
            }
        }
    }

    public static void main(String[] args) {

    }
}
