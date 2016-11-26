
import java.util.ArrayList;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public class Node {
        int val;
        int idx;
        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        LinkedList<Node> linkedList = new LinkedList<Node>();
        int n = nums.length;
        if (n < k || k == 0) return res;
        for (int i = 0; i < k - 1; i++) {
            while (!linkedList.isEmpty() && linkedList.getLast().val < nums[i]) {
                linkedList.removeLast();
            }
            linkedList.add(new Node(nums[i], i));
        }
        for (int i = k - 1; i < n; i++) {
            if (!linkedList.isEmpty() && linkedList.getFirst().idx <= i - k) {
                linkedList.removeFirst();
            }
            while (!linkedList.isEmpty() && linkedList.getLast().val < nums[i]) {
                linkedList.removeLast();
            }
            linkedList.add(new Node(nums[i], i));
            res.add(linkedList.getFirst().val);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}