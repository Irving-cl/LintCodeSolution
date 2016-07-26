
public class MoveZeroes {

    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public static void moveZeroes(int[] nums) {
        int i1 = 0;
        while (i1 < nums.length && nums[i1] != 0) {
            i1++;
        }
        for (int i2 = i1 + 1; i2 < nums.length; i2++) {
            if (nums[i2] != 0) {
                nums[i1] = nums[i2];
                nums[i2] = 0;
                i1++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = { 0, 1, 0, 3, 12 };
        moveZeroes(test);
        for (int i = 0; i < 5; i++) {
            System.out.println(test[i]);
        }
    }
}
