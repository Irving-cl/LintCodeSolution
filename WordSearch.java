
public class WordSearch {

    public int[][] adj = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    public boolean[][] vis;

    public boolean dfs(int idx, int x, int y, String word, char[][] board, int m, int n) {
        if (word.charAt(idx) != board[x][y]) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        }
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + adj[i][0];
            int yy = y + adj[i][1];
            if (xx >= 0 && xx < m && yy >= 0 && yy < n && !vis[xx][yy]) {
                if (dfs(idx + 1, xx, yy, word, board, m, n)) {
                    return true;
                }
            }
        }
        vis[x][y] = false;
        return false;
    }

    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        if (n == 0) {
            return false;
        }
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(0, i, j, word, board, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
