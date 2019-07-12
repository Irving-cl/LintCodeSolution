
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxCon = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int j = nums[i];
                while (set.contains(j)) {
                    set.remove(j++);
                }
                maxCon = Math.max(maxCon, j - nums[i]);
            }
        }
        return maxCon;
    }

    public static void main(String[] args) {

    }
}

