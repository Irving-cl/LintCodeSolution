
public class DigitCounts {

    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int[] a = new int[10];
        int digits = 0;
        if (k == 0) {
            if (n == 0) {
                return 1;
            }
            a[0] = 0;
            a[1] = 1;
            a[2] = 10;
            int temp = 90;
            int idx = 0;
            int behind = 0;
            for (int i = 3; i <= 9; i++) {
                a[i] = (a[i - 1] * 10) + temp;
                temp *= 10;
            }
            temp = 1;
            while (n > 0) {
                int digit = n % 10;
                n /= 10;
                if (n > 0) {
                    if (digit == 0) {
                        digits += behind + 1;
                    } else {
                        digits += temp;
                    }
                }
                digits += digit * a[idx++];
                behind = behind + digit * temp;
                temp *= 10;
            }
            return digits;
        }
        a[0] = 0;
        a[1] = 1;
        int temp = 10;
        for (int i = 2; i <= 9; i++) {
            a[i] = i * temp;
            temp *= 10;
        }
        int idx = 0;
        int t = 1;
        int behind = 0;
        while (n > 0) {
            int digit = n % 10;
            digits += digit * a[idx++];
            if (digit > k) {
                digits += t;
            } else if (digit == k) {
                digits += behind + 1;
            }
            behind = behind + digit * t;
            t *= 10;
            n /= 10;
        }
        return digits;
    }

    public static void main(String[] args) {

    }
}

