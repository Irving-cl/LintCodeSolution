
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordSearch2 {

    public class Trie {
        public boolean sub;
        public Trie[] p;
        public Trie() {
            this.sub = false;
            p = new Trie[26];
            for (int i = 0; i < 26; i++) {
                p[i] = null;
            }
        }
    }

    public void insert(String word, Trie node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.p[c - 'a'] == null) {
                node.p[c - 'a'] = new Trie();
            }
            node = node.p[c - 'a'];
        }
        node.sub = true;
    }

    private int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    private int m;
    private int n;

    private boolean[][] vis;

    private void dfs(int x, int y, Trie node, ArrayList<Character> path, Set<String> res, char[][] board) {
        if (node.sub == true) {
            char buf[] = new char[path.size()];
            for (int i = 0; i < buf.length; i++) {
                buf[i] = path.get(i);
            }
            res.add(new String(buf));
        }
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int ax = x + dir[i][0];
            int ay = y + dir[i][1];
            if (ax >= 0 && ax < m && ay >= 0 && ay < n && !vis[ax][ay]) {
                char c = board[ax][ay];
                if (node.p[c - 'a'] != null) {
                    path.add(c);
                    dfs(ax, ay, node.p[c - 'a'], path, res, board);
                    path.remove(path.size() - 1);
                }
            }
        }
        vis[x][y] = false;
    }

    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        Trie root = new Trie();
        ArrayList<String> res = new ArrayList<String>();
        Set<String> resSet = new HashSet<String>();
        ArrayList<Character> path = new ArrayList<Character>();
        m = board.length;
        if (m == 0) {
            return res;
        }
        n = board[0].length;
        for (String word : words) {
            insert(word, root);
        }
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = false;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                path.add(c);
                if (root.p[c - 'a'] != null) {
                    dfs(i, j, root.p[c - 'a'], path, resSet, board);
                }
                path.remove(path.size() - 1);
            }
        }
        for (String str : resSet) {
            res.add(str);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}