
public class MedianOfTwoSortedArrays {

    private double findKth(int[] A, int i, int m, int[] B, int j, int n, int k) {
        if (m > n) return findKth(B, j, n, A, i, m, k);
        if (m == 0) return B[j + k - 1];
        if (k == 1) return Math.min(A[i], B[j]);
        int pa = Math.min(k / 2, m);
        int pb = k - pa;
        if (A[i + pa - 1] < B[j + pb - 1]) {
            return findKth(A, i + pa, m - pa, B, j, n, k - pa);
        } else if (A[i + pa - 1] > B[j + pb - 1]) {
            return findKth(A, i, m, B, j + pb, n - pb, k - pb);
        } else {
            return A[i + pa - 1];
        }
    }

    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if ((m + n) % 2 == 1) {
            return findKth(A, 0, m, B, 0, n, (m + n) / 2 + 1);
        } else {
            return (findKth(A, 0, m, B, 0, n, (m + n) / 2) +
                    findKth(A, 0, m, B, 0, n, (m + n) / 2 + 1)) / 2.0;
        }
    }

    public static void main(String[] args) {

    }
}