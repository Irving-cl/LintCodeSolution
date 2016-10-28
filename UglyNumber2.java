
public class UglyNumber2 {

    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        int[] uNums = new int[n];
        uNums[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.min(uNums[idx2] * 2, uNums[idx3] * 3);
            temp = Math.min(uNums[idx5] * 5, temp);
            if (temp % 2 == 0) {
                idx2++;
            }
            if (temp % 3 == 0) {
                idx3++;
            }
            if (temp % 5 == 0) {
                idx5++;
            }
            uNums[i] = temp;
        }
        return uNums[n - 1];
    }

    public static void main(String[] args) {

    }
}
