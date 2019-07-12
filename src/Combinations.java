
import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public void help(int idx, int left, int n, List<Integer> cur, List<List<Integer>> res) {
        if (left == 0) {
            res.add(new ArrayList<Integer>(cur));
        } else {
            for (int i = idx; i + left <= n + 1; i++) {
                cur.add(i);
                help(i + 1, left - 1, n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        help(1, k, n, cur, res);
        return res;
    }

    public static void main(String[] args) {

    }
}

