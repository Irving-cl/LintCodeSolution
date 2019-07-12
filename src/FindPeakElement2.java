import java.util.ArrayList;
import java.util.List;

public class FindPeakElement2 {

    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> list = new ArrayList<Integer>();
        int m = A.length;
        if (m == 0) {
            return list;
        }
        int n = A[0].length;
        int[][] surround = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int x = i + surround[k][0];
                    int y = j + surround[k][1];
                    if (A[x][y] >= A[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        
    }
};