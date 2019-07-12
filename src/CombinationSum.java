
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CombinationSum {

    private List<List<Integer>> list;

    public void dfs(int left, int idx, List<Integer> cur, int[] candidates) {
        if (left == 0) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = idx; i < candidates.length && candidates[i] <= left; i++) {
            int cand = candidates[i];
            cur.add(cand);
            dfs(left - cand, i, cur, candidates);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < candidates.length; i++) {
            treeSet.add(candidates[i]);
        }
        int[] cands = new int[treeSet.size()];
        int i = 0;
        for (Integer ele : treeSet) {
            cands[i++] = ele;
        }
        list = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(target, 0, cur, cands);
        return list;
    }

    public static void main(String[] args) {

    }
}

