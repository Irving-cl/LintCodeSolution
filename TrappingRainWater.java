
public class TrappingRainWater {

    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int tot = 0;
        int l = 0;
        int r = heights.length - 1;
        int lMax = 0;
        int rMax = 0;
        while (l < r) {
            lMax = Math.max(l, heights[l]);
            rMax = Math.max(r, heights[r]);
            if (heights[l] < heights[r]) {
                tot += lMax - heights[l++];
            } else {
                tot += rMax - heights[r--];
            }
        }
        return tot;
    }

    public static void main(String[] args) {

    }
}

