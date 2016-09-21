
import java.util.ArrayList;

public class kSum2 {

    public int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    public void help(int idx, int left, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int[] A) {
        if (left == 0) {
            if (sum(cur) == target) {
                ArrayList<Integer> cpy = new ArrayList<Integer>(cur);
                res.add(cpy);
            }
        } else {
            for (int i = idx; i + left <= A.length; i++) {
                cur.add(A[i]);
                help(i + 1, left - 1, target, res, cur, A);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        help(0, k, target, res, cur, A);
        return res;
    }

    public static void main(String[] args) {

    }
}

