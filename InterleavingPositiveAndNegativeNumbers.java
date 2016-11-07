
public class InterleavingPositiveAndNegativeNumbers {

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        int len = A.length;
        int a = 0;
        int b = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (A[i] < 0) { a++; }
            else { b++; }
        }
        if (a < b) {
            flag = true;
        }
        a = 0;
        b = 0;
        while (2 * a < len && 2 * b + 1 < len) {
            while (2 * a < len && ((A[2 * a] < 0) ^ flag)) { a++; }
            while (2 * b + 1 < len && ((A[2 * b + 1] > 0) ^ flag)) { b++; }
            if (2 * a < len && 2 * b + 1 < len) {
                swap(A, 2 * a, 2 * b + 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}

