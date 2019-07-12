
import java.util.ArrayList;

public class IntervalSum {

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
    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
        ArrayList<Long> res = new ArrayList<Long>();
        long[] pfs = new long[A.length + 1];
        pfs[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            pfs[i] = A[i - 1] + pfs[i - 1];
        }
        for (Interval interval : queries) {
            res.add(pfs[interval.end + 1] - pfs[interval.start]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
