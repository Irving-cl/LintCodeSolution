
public class LinkedListCycle2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                slow = null;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow == null) {
            return null;
        }
        slow = dummy;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}