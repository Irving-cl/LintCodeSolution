
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ExpressionTreeBuild {

    public class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;
        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }

    public ArrayList<String> convertToRPN(String[] expression) {
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
        return ans;
    }

    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        ArrayList<String> rpn = convertToRPN(expression);
        if (rpn.size() == 0) return null;
        Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();
        for (int i = 0; i < rpn.size(); i++) {
            char tmp = rpn.get(i).charAt(0);
            if ('0' <= tmp && tmp <= '9') {
                stack.push(new ExpressionTreeNode(rpn.get(i)));
            } else {
                ExpressionTreeNode cur = new ExpressionTreeNode(rpn.get(i));
                cur.right = stack.pop();
                cur.left = stack.pop();
                stack.push(cur);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }
}