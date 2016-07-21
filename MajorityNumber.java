
import java.util.ArrayList;

public class MajorityNumber {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int ma = 0;
        int c = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (c == 0) {
                ma = nums.get(i);
                c++;
            } else {
                if (nums.get(i) == ma) {
                    c++;
                } else {
                    c--;
                }
            }
        }
        return ma;
    }
    
    public static void main(String[] args) {
        
    }
}
