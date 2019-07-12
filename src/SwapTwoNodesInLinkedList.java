
public class SwapTwoNodesInLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode n1 = null;
        ListNode n2 = null;
        while (p.next != null) {
            if (p.next.val == v1) {
                n1 = p;
            } else if (p.next.val == v2) {
                n2 = p;
            }
            p = p.next;
        }
        if (n1 == null || n2 == null) {
            return dummy.next;
        }
        if (n1.next == n2) {
            n1.next = n2.next;
            n2.next = n1.next.next;
            n1.next.next = n2;
            return dummy.next;
        } else if (n2.next == n1) {
            n2.next = n1.next;
            n1.next = n2.next.next;
            n2.next.next = n1;
            return dummy.next;
        }
        ListNode temp1 = n1.next;
        ListNode temp2 = n2.next;
        n1.next = temp2;
        ListNode temp3 = temp2.next;
        temp2.next = temp1.next;
        temp1.next = temp3;
        n2.next = temp1;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}