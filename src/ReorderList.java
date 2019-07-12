

public class ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode p = dummy.next;
        while (p != null) {
            dummy.next = p;
            dummy = dummy.next;
            p = p.next;
            dummy.next = prev;
            dummy = dummy.next;
            prev = prev.next;
        }
        dummy.next = prev;
    }

    public static void main(String[] args) {

    }
}

