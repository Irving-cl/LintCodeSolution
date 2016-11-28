
import java.util.Stack;

public class MaximalRectangle {

    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i <= height.length; ) {
            int h = i == height.length ? 0 : height[i];
            if (stack.empty() || h >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int tmp = stack.pop();
                int l = stack.empty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, l * height[tmp]);
            }
        }
        return ans;
    }

    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[][] height = new int[m][n];
        for (int i = 0; i < n; i++) height[0][i] = matrix[0][i] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]) {
                    height[i][j] = height[i - 1][j] + 1;
                } else {
                    height[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, largestRectangleArea(height[i]));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}