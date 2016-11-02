
import java.util.List;
import java.util.Iterator;
import java.util.Stack;

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> stack;
    private NestedInteger nextInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return nextInt == null ? null : nextInt.getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else if ((nextInt = stack.peek().next()).isInteger()) {
                return true;
            } else {
                stack.push(nextInt.getList().iterator());
            }
        }
        return false;
    }

    @Override
    public void remove() {}
}
