
public class SortColors {

    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int r = 0;
        int b = nums.length - 1;
        for (int i = 0; i <= b; ) {
            if (nums[i] == 0) {
                nums[i++] = nums[r];
                nums[r++] = 0;
            } else if (nums[i] == 2) {
                nums[i] = nums[b];
                nums[b--] = 2;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {

    }
}

