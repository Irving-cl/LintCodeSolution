
public class FindtheMissingNumber {

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        int miss = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            miss ^= nums[i];
            miss ^= i;
        }
        miss ^= n;
        return miss;
    }

    public static void main(String[] args) {

    }
}

