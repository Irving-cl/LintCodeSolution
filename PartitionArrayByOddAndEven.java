
public class PartitionArrayByOddAndEven {

    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (nums[l] % 2 == 1 && l < r) {
                l++;
            }
            while (nums[r] % 2 == 0 && l < r) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
