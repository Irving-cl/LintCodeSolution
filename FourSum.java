
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        int n = numbers.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int l = j + 1;
                int r = n - 1;
                int temp = target - numbers[i] + numbers[j];
                while (l < r) {
                    if (numbers[l] + numbers[r] == temp) {
                        ArrayList<Integer> qua = new ArrayList<Integer>();
                        qua.add(numbers[i]);
                        qua.add(numbers[j]);
                        qua.add(numbers[l]);
                        qua.add(numbers[r]);
                        res.add(qua);
                        l++;
                        while (l < r && numbers[l] == numbers[l - 1]) { l++; }
                    } else if (numbers[l] + numbers[r] > temp) {
                        r--;
                    } else {
                        l++;
                    }
                }
                while (j < n - 2 && numbers[j] == numbers[j + 1]) { j++; }
            }
            while (i < n - 3 && numbers[i] == numbers[i + 1]) { i++; }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

