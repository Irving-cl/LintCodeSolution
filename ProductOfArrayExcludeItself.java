
import java.util.ArrayList;

public class ProductOfArrayExcludeItself {

    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> B = new ArrayList<Long>();
        for (int i = 0; i < A.size(); i++) {
            B.add(1L);
        }
        long a = 1;
        long b = 1;
        for (int i = 0, j = A.size() - 1; i < A.size(); i++, j--) {
            B.set(i, B.get(i) * a);
            B.set(j, B.get(j) * b);
            a *= A.get(i);
            b *= A.get(j);
        }
        return B;
    }

    public static void main(String[] args) {

    }
}
