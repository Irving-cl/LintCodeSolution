
import java.util.ArrayList;
import java.util.List;

public class SingleNumber3 {

    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp ^= A[i];
        }
        int last = temp & (-temp);
        List<Integer> singleNumbers = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        for (int i = 0; i < A.length; i++) {
            if ((last & A[i]) == 0) {
                a ^= A[i];
            } else {
                b ^= A[i];
            }
        }
        singleNumbers.add(a);
        singleNumbers.add(b);
        return singleNumbers;
    }

    public static void main(String[] args) {

    }
}

