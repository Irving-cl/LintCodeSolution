
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermutationIndex2 {

    public long p(int n) {
        return n <= 1 ? 1 : n * p(n - 1);
    }

    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        long idx = 1;
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int j = i; j < n; j++) {
                if (!cnt.containsKey(A[j])) {
                    cnt.put(A[j], 1);
                } else {
                    cnt.put(A[j], cnt.get(A[j]) + 1);
                }
            }
            long temp = p(n - 1 - i);
            long accum = 1;
            ArrayList<Integer> small = new ArrayList<Integer>();
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                accum *= p(entry.getValue());
                if (entry.getKey() < A[i]) {
                    small.add(entry.getValue());
                }
            }
            for (Integer s : small) {
                idx += (temp / (accum / s));
            }
        }
        return idx;
    }

    public static void main(String[] args) {

    }
}

