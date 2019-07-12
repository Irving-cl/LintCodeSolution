
public class DeleteDigits {

    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        int rem = A.length() - k;
        String res = new String("");
        int idx = 0;
        for (int i = 0; i < rem; i++) {
            int digit = 10;
            int cand = 0;
            for (int j = idx; j <= k + i; j++) {
                if (A.charAt(j) - '0' < digit) {
                    digit = A.charAt(j) - '0';
                    cand = j;
                }
            }
            if (digit != 0 || res.length() > 0) {
                res += (char)(digit + '0');
            }
            idx = cand + 1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}