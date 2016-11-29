
public class IntervalSum2 {

    private int N;
    private long[] s;

    private void upd(int x, int l, int r, int pos, int val) {
        if (l + 1 >= r) {
            s[x] = val;
        } else {
            int m = (l + r) >> 1;
            if (pos <= m) upd(2 * x, l, m, pos, val);
            else upd(2 * x + 1, m, r, pos, val);
            s[x] = s[2 * x] + s[2 * x + 1];
        }
    }

    private long sum(int x, int l, int r, int lq, int rq) {
        if (lq <= l && r <= rq) {
            return s[x];
        }
        if (rq <= l || r <= lq) {
            return 0;
        }
        int m = (l + r) >> 1;
        return sum(2 * x, l, m, lq, rq) + sum(2 * x + 1, m, r, lq, rq);
    }

    /**
     * @param A: An integer array
     */
    public IntervalSum2(int[] A) {
        int len = A.length;
        N = 1;
        while (N < len) {
            N <<= 1;
        }
        s = new long[N * 2];
        for (int i = 0; i < len; i++) {
            s[N + i] = A[i];
        }
        for (int i = N - 1; i > 0; i--) {
            s[i] = s[i * 2] + s[i * 2 + 1];
        }
    }

    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return sum(1, 0, N, start, end + 1);
    }

    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        upd(1, 0, N, index + 1, value);
    }

    public static void main(String[] args) {

    }
}