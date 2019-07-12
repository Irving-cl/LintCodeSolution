
import java.util.Stack;

public class LargestRectangleInHistogram {

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

    public static void main(String[] args) {

    }
}