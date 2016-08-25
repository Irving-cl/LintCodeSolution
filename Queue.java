import java.util.Stack;

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int tp;
    
    public Queue() {
       tp = 0;
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        if (stack1.isEmpty()) {
            tp = element;
        }
        stack1.push(element);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int ret = stack2.pop();
        tp = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return ret;
    }

    public int top() {
        return tp;
    }
}