
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {

    public void help(int idx, int[] nums, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
        if (idx == nums.length) {
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
        } else {
            cur.add(nums[idx]);
            help(idx + 1, nums, cur, res);
            cur.remove(cur.size() - 1);
            if (cur.isEmpty() || nums[idx] != cur.get(cur.size() - 1)) {
                help(idx + 1, nums, cur, res);
            }
        }
    }

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(nums);
        help(0, nums, cur, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
