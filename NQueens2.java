
import java.util.ArrayList;
import java.util.List;

public class NQueens2 {

    List<Integer> qy;
    int cnt;

    public void dfs(int idx, int n) {
        if (idx == qy.size()) {
            cnt++;
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
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        qy = new ArrayList<Integer>();
        cnt = 0;
        dfs(0, n);
        return cnt;
    }

    public static void main(String[] args) {

    }
}
