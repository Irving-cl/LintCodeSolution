
import java.util.ArrayList;
import java.util.HashMap;

public class MajorityNumber3 {

    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ele = 0;
        boolean first = true;
        for (int i : nums) {
            if (!cnt.containsKey(i)) {
                cnt.put(i, 1);
            } else {
                cnt.put(i, cnt.get(i) + 1);
            }
            if (first || cnt.get(i) > cnt.get(ele)) {
                ele = i;
                first = false;
            }
        }
        return ele;
    }

    public static void main(String[] args) {

    }
}
