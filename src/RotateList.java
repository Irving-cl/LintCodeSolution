
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        for (int i = 0; i < len - k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = p1;
        while (p2.next != null) {
            p2 = p2.next;
        }
        p2.next = dummy.next;
        p2 = p1.next;
        p1.next = null;
        return p2;
    }

    public static void main(String[] args) {

    }
}
