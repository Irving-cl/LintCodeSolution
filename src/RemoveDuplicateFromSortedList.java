
public class RemoveDuplicateFromSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            if (p1.val == p2.val) {
                p2 = p2.next;
            } else {
                p1.next = p2;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        p1.next = null;
        return head;
    }

    public static void main(String[] args) {
        
    }
}
