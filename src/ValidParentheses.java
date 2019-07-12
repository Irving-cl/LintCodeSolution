import java.util.Stack;

public class ValidParentheses {

    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.empty() || (stack.peek() != cur - 1 && stack.peek() != cur - 2)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        
    }
};