
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int n = numbers.length;
        for (int i = 0; i < n - 2; i++) {
            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                int val = numbers[i] + numbers[lo] + numbers[hi];
                if (val == 0) {
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    arrayList.add(numbers[i]);
                    arrayList.add(numbers[lo]);
                    arrayList.add(numbers[hi]);
                    ret.add(arrayList);
                    while (lo < hi && numbers[lo] == numbers[lo + 1]) { lo++; }
                    lo++;
                } else if (val > 0) {
                    hi--;
                } else {
                    lo++;
                }
            }
            while (i < n - 2 && numbers[i] == numbers[i + 1]) { i++; }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}