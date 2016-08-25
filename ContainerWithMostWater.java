
public class ContainerWithMostWater {

    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}