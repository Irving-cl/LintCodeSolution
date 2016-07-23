
public class MergeTwoSortedArrays {

    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        int[] mergedArray = new int[m + n];
        for (; i1 < m && i2 < n; i++) {
            if (A[i1] < B[i2]) {
                mergedArray[i] = A[i1++];
            } else{
                mergedArray[i] = B[i2++];
            }
        }
        if (i1 == m) {
            for (; i < m + n; i++) {
                mergedArray[i] = B[i2++];
            }
        } else {
            for (; i < m + n; i++) {
                mergedArray[i] = A[i1++];
            }
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int A[] = { 1, 2, 3, 4 };
        int B[] = { 2, 4, 5, 6 };
        int C[] = mergeSortedArray(A, B);
        for (int i = 0; i < C.length; i++) {
            System.out.println(C[i]);
        }
    }
}
