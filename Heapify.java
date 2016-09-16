
public class Heapify {

    public static void percolateDown(int hole, int[] A) {
        int temp = A[hole];
        int child = 0;
        for ( ; hole * 2 + 1 <= A.length - 1; hole = child) {
            child = hole * 2 + 1;
            if (child != A.length - 1 && A[child] > A[child + 1]) {
                child++;
            }
            if (temp > A[child]) {
                A[hole] = A[child];
            } else {
                break;
            }
        }
        A[hole] = temp;
    }

    /**
     * @param A: Given an integer array
     * @return: void
     */
    public static void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            percolateDown(i, A);
        }
    }

    public static void main(String[] args) {
        int A[] = { 45,39,32,11 };
        heapify(A);
    }
}

