
public class CountOneInBinary {

    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public static int countOnes(int num) {
        int ones = 0;
        while (num != 0) {
            num = num & (num - 1);
            ones++;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(countOnes(32));
        System.out.println(countOnes(5));
        System.out.println(countOnes(1023));
        System.out.println(countOnes(Integer.MIN_VALUE));
    }

}
