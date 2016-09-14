
import java.util.Arrays;

public class TheSmallestDifference {

    int lowerBound(int[] array, int num) {
        int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (array[mid] < num) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        if (A.length < B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        Arrays.sort(B);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int idx = lowerBound(B, A[i]);
            ans = Math.min(ans, Math.abs(A[i] - B[idx]));
            if (idx > 0) {
                ans = Math.min(ans, Math.abs(A[i] - B[idx - 1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

