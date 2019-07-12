
public class CreateMaximumNumber {

    public int[] maxSubArray(int[] nums, int k) {
        int[] ret = new int[k];
        int top = 0;
        for (int i = 0; i < nums.length; i++) {
            while (top > 0 && nums.length - i + top > k && nums[i] > ret[top - 1]) top--;
            if (top < k) ret[top++] = nums[i];
        }
        return ret;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ret = new int[m + n];
        int i = 0;
        int j = 0;
        for (int idx = 0; idx < m + n; idx++) {
            if (greater(nums1, i, nums2, j)) {
                ret[idx] = nums1[i++];
            } else {
                ret[idx] = nums2[j++];
            }
        }
        return ret;
    }

    /**
     * @param nums1 an integer array of length m with digits 0-9
     * @param nums2 an integer array of length n with digits 0-9
     * @param k an integer and k <= m + n
     * @return an integer array
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ret = null;
        for (int i = Math.max(0, k - n); i <= Math.min(m, k); i++) {
            int[] cand = merge(maxSubArray(nums1, i), maxSubArray(nums2, k - i));
            if (ret == null || greater(cand, 0, ret, 0)) {
                ret = cand;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}