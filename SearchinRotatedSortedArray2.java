
public class SearchinRotatedSortedArray2 {

    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public boolean search(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        if (r < 0) {
            return false;
        }
        while (l <= r) {
            int m = (l + r) >> 1;
            if (A[m] == target) {
                return true;
            }
            if (A[m] > A[r]) {
                if (target < A[m] && target >= A[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (A[m] < A[r]) {
                if (target > A[m] && target <= A[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                r--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
