
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Point p1 = points[i];
            int ver = 1;
            int same = 0;
            HashMap<Double, Integer> hashMap = new HashMap<Double, Integer>();
            for (int j = i + 1; j < n; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x) {
                    ver++;
                    if (p1.y == p2.y) {
                        same++;
                    }
                } else {
                    double slope = (double)(p2.y - p1.y) / (p2.x - p1.x);
                    if (hashMap.containsKey(slope)) {
                        hashMap.put(slope, hashMap.get(slope) + 1);
                    } else {
                        hashMap.put(slope, 2);
                    }
                }
            }
            ans = Math.max(ans, ver);
            for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
                ans = Math.max(ans, entry.getValue() + same);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}