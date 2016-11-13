
import java.util.TreeMap;

public class SubarraySumClosest {

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        treeMap.put(0, -1);
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (treeMap.containsKey(prefixSum)) {
                res[0] = treeMap.get(prefixSum) + 1;
                res[1] = i;
                break;
            } else {
                Integer lo = treeMap.lowerKey(prefixSum);
                if (lo != null) {
                    if (Math.abs(prefixSum - lo) < diff) {
                        diff = Math.abs(prefixSum - lo);
                        res[0] = treeMap.get(lo) + 1;
                        res[1] = i;
                    }
                }
                Integer hi = treeMap.higherKey(prefixSum);
                if (hi != null) {
                    if (Math.abs(prefixSum - hi) < diff) {
                        diff = Math.abs(prefixSum - hi);
                        res[0] = treeMap.get(hi) + 1;
                        res[1] = i;
                    }
                }
            }
            treeMap.put(prefixSum, i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}