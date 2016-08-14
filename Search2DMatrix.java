
public class Search2DMatrix {

    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        for (int i = m - 1, j = 0; j < n && i >= 0; ) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
};