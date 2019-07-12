
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void help(List<List<Integer>> res, int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                cur.add(nums[i]);
            }
            res.add(cur);
        } else {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (int i = idx; i < nums.length; i++) {
                if (!hashSet.contains(nums[i])) {
                    swap(nums, i, idx);
                    help(res, nums, idx + 1);
                    swap(nums, i, idx);
                    hashSet.add(nums[i]);
                }
            }
        }
    }

    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        help(res, nums, 0);
        return res;
    }

    public static void main(String[] args) {

    }
}
