
import java.util.*;

public class ExpressionEvaluation {

    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        ArrayList<String> ans = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        Map<String, Integer> p = new TreeMap<String, Integer>();
        p.put("#", 0);
        p.put("+", 1);
        p.put("-", 1);
        p.put("*", 2);
        p.put("/", 2);
        stack.push("#");
        for (int i = 0; i < expression.length; i++) {
            char tmp = expression[i].charAt(0);
            if (tmp == '(') {
                stack.push("(");
            } else if (tmp == ')') {
                while (stack.peek().compareTo("(") != 0) {
                    ans.add(stack.pop());
                }
                stack.pop();
            } else if ('0' <= tmp && tmp <= '9') {
                ans.add(expression[i]);
            } else {
                while (stack.peek().compareTo("(") != 0 && p.get(stack.peek()) >= p.get(expression[i])) {
                    ans.add(stack.pop());
                }
                stack.add(expression[i]);
            }
        }
        while (stack.size() > 1) {
            ans.add(stack.pop());
        }
        Stack<Integer> nums = new Stack<Integer>();
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).compareTo("+") == 0) {
                int a = nums.pop();
                int b = nums.pop();
                nums.push(b + a);
            } else if (ans.get(i).compareTo("-") == 0) {
                int a = nums.pop();
                int b = nums.pop();
                nums.push(b - a);
            } else if (ans.get(i).compareTo("*") == 0) {
                int a = nums.pop();
                int b = nums.pop();
                nums.push(b * a);
            } else if (ans.get(i).compareTo("/") == 0) {
                int a = nums.pop();
                int b = nums.pop();
                nums.push(b / a);
            } else {
                nums.push(Integer.valueOf(ans.get(i)));
            }
        }
        return nums.isEmpty() ? 0 : nums.peek();
    }

    public static void main(String[] args) {

    }
}