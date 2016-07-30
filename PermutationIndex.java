
public class PermutationIndex {

    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[i]) {
                    B[i]++;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            ans = ans * (n - i) + B[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
