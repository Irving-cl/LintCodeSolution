
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountOfSmallerNumberBeforeItself {

    private int[] s;

    private int query(int x, int l, int r, int lq, int rq) {
        if (lq<=l&&r<=rq) return s[x];
        if (r<=lq||rq<=l) return 0;
        int m = (l + r) >> 1;
        return query(2 * x, l, m, lq, rq) + query(2 * x + 1, m, r, lq, rq);
    }

    private void insert(int x, int l, int r, int pos) {
        if (l + 1 >= r) {
            s[x]++;
            return;
        }
        int m = (l + r) >> 1;
        if (pos <= m) insert(2 * x, l, m, pos);
        else insert(2 * x + 1, m, r, pos);
        s[x] = s[2 * x] + s[2 * x + 1];
    }

    /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is
     *          smaller than it and return count number array
     */
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        ArrayList<Integer> ret = new ArrayList<>();
        int n = A.length;
        if (n == 0) return ret;
        HashMap<Integer, Integer> lsh = new HashMap<Integer, Integer>();
        int[] B = new int[A.length];
        for (int i = 0; i < n; i++) {
            B[i] = A[i];
        }
        Arrays.sort(B);
        lsh.put(B[0], 1);
        for (int i = 1; i < n; i++) {
            if (B[i] != B[i - 1]) {
                lsh.put(B[i], lsh.size() + 1);
            }
        }
        int N = 1 << 14;
        s = new int[2 * N];
        for (int i = 0; i < N; i++) s[i] = 0;
        for (int i = 0; i < n; i++) {
            ret.add(query(1, 0, N, 0, lsh.get(A[i]) - 1));
            insert(1, 0, N, lsh.get(A[i]));
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}