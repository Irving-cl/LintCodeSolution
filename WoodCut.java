
public class WoodCut {

    public int pieces(int[] L, int len) {
        int cnt = 0;
        for (int i = 0; i < L.length; i++) {
            cnt += L[i] / len;
        }
        return cnt;
    }

    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int lim = 0;
        int n = L.length;
        for (int i = 0; i < n; i++) {
            lim = Math.max(lim, L[i]);
        }
        int lo = 1;
        int hi = lim;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (pieces(L, mid) >= k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    public static void main(String[] args) {

    }
}

