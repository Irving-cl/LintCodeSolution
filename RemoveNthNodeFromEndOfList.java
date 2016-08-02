
public class RemoveNthNodeFromEndOfList {

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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        dummy.next = head;
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        if (cnt < n) {
            return dummy.next;
        }
        for (int i = 0; i < cnt - n; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        
    }
}
