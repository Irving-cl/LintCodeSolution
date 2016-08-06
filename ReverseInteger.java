
public class ReverseInteger {

    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public static int reverseInteger(int n) {
        long r = 0;
        while (n != 0) {
            r = r * 10 + n % 10;
            n /= 10;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(-123));
    }
}
