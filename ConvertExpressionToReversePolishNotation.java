
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ConvertExpressionToReversePolishNotation {

    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        ArrayList<String> ans = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        Map<String, Integer> p = new TreeMap<String, Integer>();
        p.put("#", 1);
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
        return ans;
    }

    public static void main(String[] args) {

    }
}