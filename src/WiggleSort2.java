
public class WiggleSort2 {

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

    int virtualIndex(int idx, int n) {
        return (1 + 2 * idx) % (n | 1);
    }

    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int mid = qs(nums, 0, n - 1, n / 2 + 1);
        int i = 0;
        int j = 0;
        int k = n - 1;
        while (j <= k) {
            if (nums[virtualIndex(j, n)] > mid) {
                swap(nums, virtualIndex(i++, n), virtualIndex(j++, n));
            } else if (nums[virtualIndex(j, n)] < mid) {
                swap(nums, virtualIndex(j, n), virtualIndex(k--, n));
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
