
public class MergeSortedArray {

    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int i = m + n - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (A[i1] > B[i2]) {
                A[i] = A[i1--];
            } else {
                A[i] = B[i2--];
            }
            i--;
        }
        if (i1 < 0) {
            while (i2 >= 0) {
                A[i2] = B[i2];
                i2--;
            }
        }
    }

    public static void main(String[] args) {
        int A[] = new int[5];
        int B[] = new int[2];
        A[0] = 1; A[1] = 2; A[2] = 3;
        B[0] = 4; B[1] = 5;
        mergeSortedArray(A, 3, B, 2);
        for (int i = 0; i < 5; i++) {
            System.out.println(A[i]);
        }
    }
}
