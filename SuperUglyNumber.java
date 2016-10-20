
public class SuperUglyNumber {

    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                nums[i] = Math.min(nums[i], primes[j] * index[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (nums[i] % primes[j] == 0) {
                    index[j]++;
                }
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {

    }
}
