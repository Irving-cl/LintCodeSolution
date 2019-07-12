
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfAirplanesInTheSky {

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (Interval interval : airplanes) {
            if (map.containsKey(interval.start)) {
                map.put(interval.start, map.get(interval.start) + 1);
            } else {
                map.put(interval.start, 1);
            }
            if (map.containsKey(interval.end)) {
                map.put(interval.end, map.get(interval.end) - 1);
            } else {
                map.put(interval.end, -1);
            }
        }
        int ans = 0;
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += entry.getValue();
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
