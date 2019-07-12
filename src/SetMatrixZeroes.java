
public class SetMatrixZeroes {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        for (int i = 0; i < m && !row0; i++) {
            if (matrix[i][0] == 0) {
                row0 = true;
            }
        }
        for (int i = 0; i < n && !col0; i++) {
            if (matrix[0][i] == 0) {
                col0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (row0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}

