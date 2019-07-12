
public class PartitionArray {

    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int i = -1;
        int j = nums.length;
        while (i < j) {
            while (i < nums.length - 1 && nums[++i] < k);
            while (j > 0 && nums[--j] >= k);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                break;
            }
        }
        return nums[j] >= k ? j : j + 1;
    }

    public static void main(String[] args) {

    }
}
