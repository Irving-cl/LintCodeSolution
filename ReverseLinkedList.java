
public class ReverseLinkedList {

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
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode last = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }
        cur.next = last;
        return cur;
    }

    public static void main(String[] args) {
        
    }
}
