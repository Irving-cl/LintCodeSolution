
public class BinarySearch {

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (high < 0) {
            return -1;
        }
        while (low < high) {
            int mid = (low + high) >> 1;
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {

    }

}
