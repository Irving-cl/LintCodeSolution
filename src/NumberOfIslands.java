import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

    public static int find(int i, int[] djs) {
        return djs[i] == i ? i : (djs[i] = find(djs[i], djs));
    }

    public static void union(int i, int j, int[] djs) {
        djs[find(i, djs)] = find(j, djs);
    }

    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public static int numIslands(boolean[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[] djs = new int[m * n];
        for (int i = 0; i < djs.length; i++) {
            djs[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    if (i < m - 1 && grid[i + 1][j]) {
                        union(i * n + j, i * n + n + j, djs);
                    }
                    if (j < n - 1 && grid[i][j + 1]) {
                        union(i * n + j, i * n + j + 1, djs);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    set.add(find(i * n + j, djs));
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        boolean[][] grid = {
            { true, true, false, false, false },
            { false, true, false, false, true },
            { false, false, false, true, true },
            { false, false, false, false, false },
            { false, false, false, false, true },
        };
        System.out.println(numIslands(grid));
    }
}
