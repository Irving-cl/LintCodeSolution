
public class Pow {

    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / myPow(x, -n);
        } else if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else {
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            } else {
                return myPow(x * x, n / 2) * x;
            }
        }
    }

    public static void main(String[] args) {

    }
}

