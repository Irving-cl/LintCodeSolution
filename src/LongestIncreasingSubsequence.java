
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        List<Integer> dp = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int idx = Collections.binarySearch(dp, cur);
            if (idx < 0) {
                idx = idx * (-1) - 1;
                if (idx == dp.size()) {
                    dp.add(cur);
                } else {
                    dp.set(idx, cur);
                }
            }
        }
        return dp.size();
    }

    public static void main(String[] args) {

    }
}

