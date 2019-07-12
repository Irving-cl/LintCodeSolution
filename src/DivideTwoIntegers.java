
import java.util.ArrayList;

public class DivideTwoIntegers {

    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        } else if (dividend == 0) {
            return 0;
        } else if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend > 0 && divisor < 0) {
            return -divide(-dividend, divisor);
        } else if (dividend < 0 && divisor > 0) {
            return -divide(dividend, -divisor);
        } else if (dividend > 0 && divisor > 0) {
            dividend = -dividend;
            divisor = -divisor;
        }
        long dvd = dividend;
        long dvs = divisor;
        ArrayList<Long> arrayList = new ArrayList<Long>();
        while (dvs >= dvd) {
            arrayList.add(dvs);
            dvs += dvs;
        }
        int res = 0;
        int n = arrayList.size();
        for (int i = n - 1; i >= 0; i--) {
            if (dvd <= arrayList.get(i)) {
                dvd -= arrayList.get(i);
                res |= (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}