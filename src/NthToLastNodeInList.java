
public class NthToLastNodeInList {

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
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        ListNode dummy = head;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        for (int i = 0; i < count - n; i++) {
            dummy = dummy.next;
        }
        return dummy;
    }

    public static void main(String[] args) {

    }
}