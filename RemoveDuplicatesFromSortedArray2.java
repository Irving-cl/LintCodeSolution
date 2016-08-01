
public class RemoveDuplicatesFromSortedArray2 {

    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int last = nums[0];
        int cnt = 1;
        int tot = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != last) {
                nums[tot++] = nums[i];
                cnt = 1;
                last = nums[i];
            } else if (cnt == 1) {
                nums[tot++] = nums[i];
                cnt++;
            }
        }
        return tot;
    }

    public static void main(String[] args) {
        
    }
}
