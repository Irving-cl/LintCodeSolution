
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ret = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                ret[0] = i + 1;
                ret[1] = map.get(target - numbers[i]);
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        Arrays.sort(ret);
        return ret;
    }

    public static void main(String[] args) {

    }
}

