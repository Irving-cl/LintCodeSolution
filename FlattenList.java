
import java.util.*;

public class FlattenList {

    public interface NestedInteger {
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

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> ret = new ArrayList<Integer>();
        Iterator<NestedInteger> iter = nestedList.listIterator();
        Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
        while (iter.hasNext() || !stack.isEmpty()) {
            if (!iter.hasNext()) {
                iter = stack.pop();
            } else {
                NestedInteger nextInt = null;
                while (!(nextInt = iter.next()).isInteger()) {
                    if (nextInt.getList().isEmpty()) break;
                    stack.push(iter);
                    iter = nextInt.getList().listIterator();
                }
                if (nextInt.isInteger()) {
                    ret.add(nextInt.getInteger());
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}