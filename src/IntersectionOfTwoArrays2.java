
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {

    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int a1[] = { 1, 2, 2, 1 };
        int a2[] = { 2, 2 };
        int ret[] = intersection(a1, a2);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
    }
}
