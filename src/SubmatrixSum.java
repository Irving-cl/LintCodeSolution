
import java.util.HashMap;

public class SubmatrixSum {

    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[2][2];
        int[][] grid = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            grid[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            grid[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = grid[i][j - 1] + matrix[i - 1][j - 1];
            }
            for (int j = 1; j <= n; j++) {
                grid[i][j] += grid[i - 1][j];
            }
        }
        boolean found = false;
        for (int i = 1; i <= m && !found; i++) {
            for (int j = i; j <= m && !found; j++) {
                HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
                hashMap.put(0, 0);
                for (int k = 1; k <= n && !found; k++) {
                    int temp = grid[j][k] - grid[i - 1][k];
                    if (hashMap.containsKey(temp)) {
                        ans[0][0] = i - 1;
                        ans[0][1] = hashMap.get(temp);
                        ans[1][0] = j - 1;
                        ans[1][1] = k - 1;
                        found = true;
                    } else {
                        hashMap.put(temp, k);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
