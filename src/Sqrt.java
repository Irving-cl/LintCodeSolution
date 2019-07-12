
public class Sqrt {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public static int sqrt(int x) {
        int lo = 0;
        int hi = Math.min(x, 46340);
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                lo = mid;
                break;
            } else if (mid * mid > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    public static void main(String[] args) {
        System.out.println(sqrt(1));
        System.out.println(sqrt(3));
        System.out.println(sqrt(4));
        System.out.println(sqrt(5));
        System.out.println(sqrt(10));
        System.out.println(sqrt(999999999));
    }
}