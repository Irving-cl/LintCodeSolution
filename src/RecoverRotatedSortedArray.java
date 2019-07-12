
import java.util.ArrayList;

public class RecoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int idx = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                idx = i;
                break;
            }
        }
        reverse(nums, 0, idx - 1);
        reverse(nums, idx, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    private void reverse(ArrayList<Integer> nums, int begin, int end) {
        while (begin < end) {
            int temp = nums.get(begin);
            nums.set(begin, nums.get(end));
            nums.set(end, temp);
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {

    }
}

