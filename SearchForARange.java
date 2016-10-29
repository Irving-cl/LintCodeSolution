
public class SearchForARange {

    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        if (A.length == 0) {
            return ans;
        }
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (A[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        ans[1] = lo;
        lo = 0;
        hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (A[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        ans[0] = lo;
        if (A[lo] == target) {
            if (A[ans[1]] > target) {
                ans[1]--;
            }
        } else {
            ans[0] = ans[1] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
