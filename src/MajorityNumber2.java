
import java.util.ArrayList;

public class MajorityNumber2 {

    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int cand1 = 0;
        int cand2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (cnt1 == 0) {
                cand1 = num;
            } else if (cnt2 == 0) {
                cand2 = num;
            }
            if (num == cand1) {
                cnt1++;
            } else if (num == cand2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == cand1) {
                cnt1++;
            } else if (num == cand2) {
                cnt2++;
            }
        }
        return cnt1 > cnt2 ? cand1 : cand2;
    }

    public static void main(String[] args) {

    }
}

