
import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        boolean flag = true;
        int closetSum = 0;
        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (flag) {
                    flag = false;
                    closetSum = sum;
                } else {
                    if (Math.abs(target - sum) < Math.abs(target - closetSum)) {
                        closetSum = sum;
                    }
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closetSum;
    }

    public static void main(String[] args) {

    }
}

