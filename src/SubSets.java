
import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {

    public void help(int idx, ArrayList<Integer> cur, int[] nums, ArrayList<ArrayList<Integer>> res) {
        if (idx == nums.length) {
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
        } else {
            cur.add(nums[idx]);
            help(idx + 1, cur, nums, res);
            cur.remove(cur.size() - 1);
            help(idx + 1, cur, nums, res);
        }
    }

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(nums);
        help(0, cur, nums, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
