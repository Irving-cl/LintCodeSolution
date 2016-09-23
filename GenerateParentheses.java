
import java.util.ArrayList;

public class GenerateParentheses {

    void help(int left, int len, String cur, ArrayList<String> res, int n) {
        if (len == n * 2) {
            res.add(cur);
            return;
        }
        if (left < n) {
            String temp = new String(cur) + "(";
            help(left + 1, len + 1, temp, res, n);
        }
        if (left > len - left) {
            String temp = new String(cur) + ")";
            help(left, len + 1, temp, res, n);
        }
    }

    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        help(0, 0, "", list, n);
        return list;
    }

    public static void main(String[] args) {

    }
}

