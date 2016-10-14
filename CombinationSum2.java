
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2 {

    public void help(int idx, int target, int[] num, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        HashSet<Integer> dup = new HashSet<Integer>();
        for (int i = idx; i < num.length && num[i] <= target; i++) {
            if (!dup.contains(num[i])) {
                dup.add(num[i]);
                cur.add(num[i]);
                help(i + 1, target - num[i], num, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        help(0, target, num, cur, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
