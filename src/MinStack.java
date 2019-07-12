
import java.util.Stack;

public class MinStack {

    public MinStack() {
        a = new Stack<Integer>();
        b = new Stack<Integer>();
    }

    public void push(int number) {
        a.push(number);
        if (b.empty()) {
            b.push(number);
        } else {
            b.push(Math.min(b.peek(), number));
        }
    }

    public int pop() {
        b.pop();
        return a.pop();
    }

    public int min() {
       return b.peek();
    }

    private Stack<Integer> a;
    private Stack<Integer> b;
}

