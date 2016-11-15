
import java.util.Arrays;
import java.util.Comparator;

public class ReorderArrayToConstructTheMinimumNumber {

    public class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            String a = s1 + s2;
            String b = s2 + s1;
            int cmp = a.compareTo(b);
            if (cmp < 0) {
                return -1;
            } else if (cmp == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        Arrays.sort(n, new MyComparator());
        String res = new String("");
        for (int i = 0; i < n.length; i++) {
            res += n[i];
        }
        int idx = 0;
        while (idx < res.length() && res.charAt(idx) == '0') { idx++; }
        return res.substring(idx);
    }

    public static void main(String[] args) {

    }
}