
public class SearchInsertPosition {

    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if (A.length == 0) {
            return 0;
        }
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (target > A[low]) {
            return low + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        
    }
};