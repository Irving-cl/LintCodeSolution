
import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].compareTo("+") == 0) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if (tokens[i].compareTo("-") == 0) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (tokens[i].compareTo("*") == 0) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if (tokens[i].compareTo("/") == 0) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }
}
