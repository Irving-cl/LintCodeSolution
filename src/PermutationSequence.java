
import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

    public void help(int idx, char[] buf, int[] p, int n, int k, List<Integer> list) {
        if (idx == n - 1) {
            int num = list.get(0);
            buf[idx] = (char)(num + '0');
        } else {
            int t = (k - 1) / p[n - 1 - idx];
            int num = list.get(t);
            buf[idx] = (char)(num + '0');
            list.remove(t);
            k = k - t * p[n - 1 - idx];
            help(idx + 1, buf, p, n, k, list);
        }
    }

    /**
     * @param n: n
     * @param k: the kth permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        char[] buf = new char[n];
        int[] p = new int[10];
        p[1] = 1;
        for (int i = 2; i < 10; i++) {
            p[i] = p[i - 1] * i;
        }
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        help(0, buf, p, n, k, list);
        return new String(buf);
    }

    public static void main(String[] args) {

    }
}
