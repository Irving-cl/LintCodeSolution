
public class LinkedListCycle {

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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f = dummy;
        ListNode s = dummy;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
            if (f.val == s.val) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}