
public class CheckPowerOf2 {

    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if (n == 0 || n == Integer.MIN_VALUE) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

    }
}
