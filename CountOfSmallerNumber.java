
import java.util.ArrayList;
import java.util.Arrays;

public class CountOfSmallerNumber {

    /**
     * @param A: An integer array
     * @return: The number of element in the array that
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        Arrays.sort(A);
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < queries.length; i++) {
            int idx = Arrays.binarySearch(A, queries[i]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            while (idx > 0 && A[idx] == A[idx - 1]) {
                idx--;
            }
            ret.add(idx);
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}