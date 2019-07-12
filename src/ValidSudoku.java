
public class ValidSudoku {

    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        int[] a = new int[9];
        int[] b = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                a[k] = 0;
                b[k] = 0;
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (a[board[i][j] - '1'] != 0) {
                        return false;
                    }
                    a[board[i][j] - '1'] = 1;
                }
                if (board[j][i] != '.') {
                    if (b[board[j][i] - '1'] != 0) {
                        return false;
                    }
                    b[board[j][i] - '1'] = 1;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    a[k] = 0;
                }
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        char c = board[i * 3 + m][j * 3 + n];
                        if (c != '.') {
                            if (a[c - '1'] != 0) {
                                return false;
                            }
                            a[c - '1'] = 1;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
