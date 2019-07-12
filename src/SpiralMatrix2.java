
public class SpiralMatrix2 {

    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int num = 1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int d = 0; d < 4; d++) {
                for (int j = 0; j < n - 2 * i - 1; j++) {
                    matrix[x][y] = num++;
                    x += move[d][0];
                    y += move[d][1];
                }
            }
            y++;
        }
        if (num == n * n) {
            matrix[x][y] = num;
        }
        return matrix;
    }

    public static void main(String[] args) {

    }
}

