
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        int dir = 0;
        int lastN = n - 1;
        int lastM = m - 1;
        int cnt = n - 1;
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[x][y]);
            if (cnt == 0) {
                switch (dir) {
                    case 0:
                        dir++;
                        cnt = lastM;
                        break;
                    case 1:
                        dir++;
                        cnt = lastN;
                        break;
                    case 2:
                        dir++;
                        lastM -= 2;
                        cnt = lastM + 1;
                        break;
                    case 3:
                        dir = 0;
                        lastN -= 2;
                        cnt = lastN + 1;
                        break;
                }
            }
            switch (dir) {
                case 0:
                    y++;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y--;
                    break;
                case 3:
                    x--;
                    break;
            }
            cnt--;
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
