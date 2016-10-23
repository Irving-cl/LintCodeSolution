
public class KthLargestElement {

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int qs(int[] nums, int l, int r, int k) {
        int pivot = nums[l];
        int i = l;
        int j = r + 1;
        for ( ; ; ) {
            while (i < r && nums[++i] < pivot) {}
            while (j > l && nums[--j] > pivot) {}
            if (i < j) {
                swap(nums, i, j);
            } else {
                break;
            }
        }
        swap(nums, l, j);
        if (r - j == k - 1) {
            return pivot;
        } else if (r - j < k - 1) {
            return qs(nums, l, j - 1, k - r + j - 1);
        } else {
            return qs(nums, j + 1, r, k);
        }
    }

    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        return qs(nums, 0, nums.length - 1, k);
    }

    public static void main(String[] args) {

    }
}
