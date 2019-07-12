
public class FindPeakElement {

    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int ans = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}