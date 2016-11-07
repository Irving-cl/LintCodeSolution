
public class FastPower {

    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        long ret = 1;
        long A = a;
        while (n != 0) {
            if ((n & 1) != 0) {
                ret = (ret * A) % b;
            }
            n = n >> 1;
            A = (A * A) % b;
        }
        return (int)(ret % b);
    }

    public static void main(String[] args) {

    }
}

