
import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {

    public int[] len = { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
    public String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public char[] buf = new char[1000];

    public void help(int idx, ArrayList<String> res, int n, String digits) {
        if (idx == n) {
            String temp = new String(buf, 0, n);
            res.add(temp);
        } else {
            int num = digits.charAt(idx) - '0';
            for (int i = 0; i < len[num]; i++) {
                buf[idx] = letters[num].charAt(i);
                help(idx + 1, res, n, digits);
            }
        }
    }

    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        help(0, res, digits.length(), digits);
        return res;
    }

    public static void main(String[] args) {

    }
}
