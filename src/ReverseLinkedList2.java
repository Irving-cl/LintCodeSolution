
public class ReverseLinkedList2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode next = null;
        ListNode conj = dummy;
        dummy.next = head;
        for (int i = 0; i < m; i++) {
            prev = prev.next;
            if (i < m - 1) {
                conj = conj.next;
            }
        }
        head = prev.next;
        for (int i = m; i < n; i++) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        conj.next.next = next;
        conj.next = prev;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

