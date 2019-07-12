
public class MaximumProductSubarray {

    public int maxProductRange(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int negs = 0;
        int product = 1;
        for (int i = left; i <= right; i++) {
            if (nums[i] < 0) {
                negs++;
            }
            product *= nums[i];
        }
        if (negs % 2 == 0) {
            return product;
        }
        int temp1 = product;
        int temp2 = product;
        for (int i = left; temp1 < 0; i++) {
            temp1 /= nums[i];
        }
        for (int i = right; temp2 < 0; i++) {
            temp2 /= nums[i];
        }
        return Math.max(temp1, temp2);
    }

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int state = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (state == 1) {
                    res = Math.max(left, right);
                }
                res = Math.max(0, res);
                state = 0;
            } else {
                if (state == 0) {
                    left = right = i;
                    state = 1;
                } else {
                    right = i;
                }
            }
        }
        if (state == 1) {
            res = Math.max(res, maxProductRange(nums, left, right));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

