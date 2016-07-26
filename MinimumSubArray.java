import java.util.ArrayList;

public class MinimumSubArray {

    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public static int minSubArray(ArrayList<Integer> nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            res = Math.min(res, sum);
            sum = Math.min(0, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(-1);
        test.add(-2);
        test.add(1);
        System.out.println(minSubArray(test));
    }
}
