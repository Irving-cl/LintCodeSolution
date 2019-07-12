
public class RemoveDuplicatesFromSortedArray {

    /**
     * @param nums: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        int last = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != last) {
                nums[len++] = nums[i];
                last = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {

    }
}
