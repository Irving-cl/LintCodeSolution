
import java.util.Comparator;
import java.util.PriorityQueue;

public class DataStreamMedian {

    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }
        int[] res = new int[n];
        int median = nums[0];
        res[0] = median;
        PriorityQueue<Integer> small = new PriorityQueue<Integer>();
        PriorityQueue<Integer> big = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 1; i < n; i++) {
            if (nums[i] > median) {
                small.add(nums[i]);
                if (small.size() - big.size() > 1) {
                    big.add(median);
                    median = small.poll();
                }
            } else {
                big.add(nums[i]);
                if (big.size() - small.size() > 0) {
                    small.add(median);
                    median = big.poll();
                }
            }
            res[i] = median;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}