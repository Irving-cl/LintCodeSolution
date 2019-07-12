
public class MatrixZigZagTraversal {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */
    public static int[] printZMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return null;
        }
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int k = 0;
        int c = 0;
        int i;
        int j;
        for (; k < n; k++) {
            if (k % 2 == 1) {
                i = 0;
                j = k;
            } else {
                i = Math.min(k, m - 1);
                j = Math.max(k - m + 1, 0);
            }
            for (int t = 0; t <= Math.min(m - 1, k); t++) {
                res[c++] = matrix[i][j];
                if (k % 2 == 1) {
                    i++;
                    j--;
                } else {
                    i--;
                    j++;
                }
            }
        }
        for (; k < m + n - 1; k++) {
            if (k % 2 == 1) {
                i = k - n + 1;
                j = n - 1;
            } else {
                i = Math.min(k, m - 1);
                j = Math.max(k - m + 1, 0);
            }
            for (int t = 0; t < Math.min(m + n - k - 1, n); t++) {
                res[c++] = matrix[i][j];
                if (k % 2 == 1) {
                    i++;
                    j--;
                } else {
                    i--;
                    j++;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int m[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = i * 3 + j + 1;
            }
        }
        int res[] = printZMatrix(m);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
        System.out.println();
        int n[][] = new int[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                n[i][j] = i * 3 + j + 1;
            }
        }
        res = printZMatrix(n);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
        System.out.println();
        int y[][] = new int[9][1];
        for (int i = 0; i < 9; i++) {
            y[i][0] = i + 1;
        }
        res = printZMatrix(y);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
        System.out.println();
    }
}
