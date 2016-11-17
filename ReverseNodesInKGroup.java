
public class ReverseNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (k > len) k = k % len;
        int groups = len / k;
        p = dummy;
        for (int i = 0; i < groups; i++) {
            ListNode prev = null;
            ListNode cur = p.next;
            ListNode next = null;
            ListNode tail = p.next;
            for (int j = 0; j < k; j++) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            p.next = prev;
            tail.next = cur;
            p = tail;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}