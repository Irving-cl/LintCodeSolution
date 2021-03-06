
public class PlusOne {

    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }
        if (i == -1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            digits[i]++;
        }
        return digits;
    }

    public static void main(String[] args) {

    }
}
