
import java.util.ArrayList;

public class ContinuousSubarraySum {

    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        int sum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                if (A[i] > sum) {
                    start = end = i;
                    sum = A[i];
                }
            } else {
                sum += A[i];
                end++;
            }
            if (sum > maxSum) {
                maxSum = sum;
                res.set(0, start);
                res.set(1, end);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
