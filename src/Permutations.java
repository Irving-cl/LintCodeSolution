
import java.util.ArrayList;
import java.util.List;

public class Permutations {

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
            for (int i = idx; i < nums.length; i++) {
                swap(nums, i, idx);
                help(res, nums, idx + 1);
                swap(nums, i, idx);
            }
        }
    }

    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            List<Integer> empty = new ArrayList<Integer>();
            res.add(empty);
            return res;
        }
        help(res, nums, 0);
        return res;
    }

    public static void main(String[] args) {

    }
}
