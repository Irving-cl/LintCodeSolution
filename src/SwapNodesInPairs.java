
public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int temp = cur.next.val;
            cur.next.val = cur.next.next.val;
            cur.next.next.val = temp;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        
    }
};