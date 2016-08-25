
public class SingleNumber2 {

    /**
     * @param A : An integer array
     * @return : An integer 
     */
    public int singleNumberII(int[] A) {
        int single = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int cnt = 0;
            for (int j = 0; j < A.length; j++) {
                cnt += ((A[j] & mask) == 0 ? 0 : 1);
            }
            if (cnt % 3 != 0) {
                single |= mask;
            }
        }
        return single;
    }

    public static void main(String[] args) {
        
    }
}