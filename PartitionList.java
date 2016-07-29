
public class PartitionList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode less = lessDummy;
        ListNode greaterDummy = new ListNode(0);
        ListNode greater = greaterDummy;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        less.next = greaterDummy.next;
        greater.next = null;
        return lessDummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        a.next = b; b.next = c; c.next = d; d.next = e; e.next = f;
        ListNode res = partition(a, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
