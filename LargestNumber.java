
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public class MyComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String lhs = (String)o1;
            String rhs = (String)o2;
            int len1 = lhs.length();
            int len2 = rhs.length();
            for (int i = 0; i < Math.min(len1, len2); i++) {
                if (lhs.charAt(i) < rhs.charAt(i)) {
                    return 1;
                } else if (lhs.charAt(i) > rhs.charAt(i)) {
                    return -1;
                }
            }
            if (len1 < len2) {
                return compare(lhs, rhs.substring(len1));
            } else if (len1 > len2) {
                return compare(lhs.substring(len2), rhs);
            }
            return 0;
        }
    }

    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        String[] numm = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            numm[i] = String.valueOf(num[i]);
        }
        Arrays.sort(numm, new MyComparator());
        String ans = new String("");
        for (int i = 0; i < numm.length; i++) {
            ans += numm[i];
        }
        int idx = 0;
        while (idx < ans.length() - 1 && ans.charAt(idx) == '0') {
            idx++;
        }
        return ans.substring(idx);
    }

    public static void main(String[] args) {

    }
}