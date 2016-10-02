
public class ConvertSortedListToBalancedBST {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while (p2 != null && p2.next != null) {
            last = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        last.next = null;
        TreeNode root = new TreeNode(p1.val);
        root.left = sortedListToBST(dummy.next);
        root.right = sortedListToBST(p1.next);
        return root;
    }

    public static void main(String[] args) {

    }
}

