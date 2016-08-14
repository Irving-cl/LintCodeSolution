
public class SortIntegers2 {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            percDown(A, i, A.length);
        }
        for (int i = A.length - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            percDown(A, 0, i);
        }
        int l = 0;
        int r = A.length - 1;
        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }

    private void percDown(int[] A, int i, int n) {
        int child = 0;
        int temp = A[i];
        for ( ;2 * i + 1 < n; i = child) {
            child = 2 * i + 1;
            if (child != n - 1 && A[child + 1] < A[child]) {
                child++;
            }
            if (temp > A[child]) {
                A[i] = A[child];
            } else {
                break;
            }
        }
        A[i] = temp;
    }

    public static void main(String[] args) {

    }
}

