import java.util.ArrayList;

public class SubarraySum {

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == 0) {
                    arrayList.add(i);
                    arrayList.add(j);
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        
    }
};