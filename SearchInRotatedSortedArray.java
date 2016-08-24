
public class SearchInRotatedSortedArray {

    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        if (r < 0) {
            return -1;
        }
        while (l < r) {
            int m = (l + r) >> 1;
            if (A[m] == target) {
                return m;
            }
            if (A[m] > A[r]) {
                if (target < A[m] && target >= A[l]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else if (A[m] < A[r]) {
                if (target > A[m] && target <= A[r]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        return A[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        
    }
}