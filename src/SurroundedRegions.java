
public class SurroundedRegions {

    private int[] ds;

    private int fi(int a) {
        return ds[a] == a ? a : (ds[a] = fi(ds[a]));
    }

    private void un(int a, int b) {
        ds[fi(a)] = ds[fi(b)];
    }

    private int h(int i, int j, int n) {
        return i * n + j + 1;
    }

    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        int size = m * n;
        ds = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            ds[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        un(fi(i * n + j + 1), fi(0));
                    }
                    if (i > 0 && board[i - 1][j] == 'O') {
                        un(fi(i * n + j + 1), fi(i * n - n + j + 1));
                    }
                    if (j > 0 && board[i][j - 1] == 'O') {
                        un(fi(i * n + j + 1), fi(i * n + j));
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (fi(0) != fi(i * n + j + 1)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}