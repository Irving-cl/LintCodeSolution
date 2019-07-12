
public class HappyNumber {

    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public static boolean isHappy(int n) {
        while (true) {
            int temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            if (temp == 4) {
                return false;
            } else if (temp == 1) {
                break;
            }
            n = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

}
