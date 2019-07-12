
import java.util.HashSet;

public class GraphValidTree {

    private int[] dj;

    public int fi(int i) {
        return (i == dj[i]) ? i : (dj[i] = fi(dj[i]));
    }

    public void un(int a, int b) {
        dj[fi(a)] = dj[fi(b)];
    }

    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        dj = new int[n];
        for (int i = 0; i < n; i++) {
            dj[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int a = fi(edges[i][0]);
            int b = fi(edges[i][1]);
            if (a == b) {
                return false;
            } else {
                un(fi(a), fi(b));
            }
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hashSet.add(fi(i));
        }
        return hashSet.size() == 1;
    }

    public static void main(String[] args) {

    }
}
