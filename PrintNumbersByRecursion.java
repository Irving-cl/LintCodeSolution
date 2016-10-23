
import java.util.ArrayList;
import java.util.List;

public class PrintNumbersByRecursion {

    public void rec(int idx, int last, int n, List<Integer> ret) {
        if (idx == n) {
            if (last != 0) {
                ret.add(last);
            }
        } else {
            for (int i = 1; i < 10; i++) {
                rec(idx + 1, last * 10 + i, n, ret);
            }
        }
    }

    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        rec(0, 0, n, ret);
        return ret;
    }

    public static void main(String[] args) {

    }
}
