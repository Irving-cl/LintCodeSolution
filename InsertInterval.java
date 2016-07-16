
import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int binary_search(List<Interval> intervals, int target) {
        if (intervals.isEmpty()) {
            return -1;
        }
        int low = 0;
        int high = intervals.size() - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (target > intervals.get(mid).start) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return intervals.get(low).start <= target ? low : low - 1;
    }

    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int i1 = binary_search(intervals, newInterval.start);
        int i2 = binary_search(intervals, newInterval.end);
        int c = ((i1 == -1 || newInterval.start > intervals.get(i1).end) ? 0 : 1)
            + ((i2 == -1 || newInterval.end > intervals.get(i2).end) ? 0 : 2);
        for (int i = 0; i <= i1; i++) {
            result.add(intervals.get(i));
        }
        switch (c) {
            case 0:
                result.add(newInterval);
                break;
            case 1:
                result.get(result.size() - 1).end = newInterval.end;
                break;
            case 2:
                result.add(new Interval(newInterval.start, intervals.get(i2).end));
                break;
            case 3:
                result.get(result.size() - 1).end = intervals.get(i2).end;
                break;
        }
        for (int i = i2 + 1; i < intervals.size(); i++) {
            result.add(intervals.get(i));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
