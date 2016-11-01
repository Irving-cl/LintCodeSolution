
public class FirstMissingPositive {

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        int idx = 0;
        while (idx < A.length) {
            if (A[idx] > 0 && A[idx] != idx + 1) {
                swap(A, idx, A[idx] - 1);
            } else {
                idx++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length;
    }

    public static void main(String[] args) {

    }
}
