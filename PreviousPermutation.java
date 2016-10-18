
import java.util.ArrayList;
import java.util.Collections;

public class PreviousPermutation {

    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        int n = nums.size();
        int idx1 = n - 1;
        while (idx1 > 0 && nums.get(idx1) >= nums.get(idx1 - 1)) {
            idx1--;
        }
        if (idx1 == 0) {
            Collections.reverse(nums);
            return nums;
        }
        int temp = nums.get(idx1 - 1);
        int idx2 = idx1;
        while (idx2 < n && nums.get(idx1 - 1) > nums.get(idx2)) {
            idx2++;
        }
        idx2--;
        nums.set(idx1 - 1, nums.get(idx2));
        nums.set(idx2, temp);
        idx2 = n - 1;
        while (idx1 < idx2) {
            int swp = nums.get(idx1);
            nums.set(idx1, nums.get(idx2));
            nums.set(idx2, swp);
            idx1++;
            idx2--;
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
