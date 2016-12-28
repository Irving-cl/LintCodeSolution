

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    List<Integer> qy;
    ArrayList<ArrayList<String>> res;

    public void dfs(int idx, int n) {
        if (idx == n) {
            ArrayList<String> sol = new ArrayList<String>();
            char[] buf = new char[n];
            for (int i = 0; i < n; i++) {
                buf[i] = '.';
            }
            for (int i = 0; i < n; i++) {
                int tmp = qy.get(i);
                buf[tmp] = 'Q';
                sol.add(new String(buf));
                buf[tmp] = '.';
            }
            res.add(sol);
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < qy.size(); j++) {
                if (qy.get(j) == i ||
                        Math.abs(qy.get(j) - i) == Math.abs(j - idx)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                qy.add(i);
                dfs(idx + 1, n);
                qy.remove(qy.size() - 1);
            }
        }
    }

    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        res = new ArrayList<ArrayList<String>>();
        qy = new ArrayList<Integer>();
        dfs(0, n);
        return res;
    }

    public static void main(String[] args) {

    }
}