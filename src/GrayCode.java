
import java.util.ArrayList;

public class GrayCode {

    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = arrayList.size() - 1; j >= 0; j--) {
                arrayList.add((1 << i) | arrayList.get(j));
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {

    }
}

