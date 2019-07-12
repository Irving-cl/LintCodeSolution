
public class InsertionSortList {

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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            ListNode temp = dummy;
            while (temp.next.val < head.val) {
                temp = temp.next;
            }
            if (temp.next != head) {
                ListNode pred1 = temp.next;
                ListNode pred2 = head.next;
                temp.next = head;
                head.next = pred1;
                prev.next = pred2;
                head = pred2;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        
    }

}
