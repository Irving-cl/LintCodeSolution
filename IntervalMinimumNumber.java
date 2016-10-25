
import java.util.ArrayList;

public class IntervalMinimumNumber {

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A,
                                                ArrayList<Interval> queries) {
        int n = A.length;
        int k = (int)(Math.log(n) / Math.log(2));
        int[][] st = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            st[i][0] = A[i - 1];
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i + (1 << j) - 1 <= n; i++) {
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Interval interval : queries) {
            int kk = (int)(Math.log(interval.end - interval.start + 1) / Math.log(2.0));
            arrayList.add(Math.min(st[interval.start + 1][kk], st[interval.end - (1 << kk) + 2][kk]));
        }
        return arrayList;
    }

    public static void main(String[] args) {

    }
}
