
public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (headA != null) {
            ListNode p = headB;
            while (p != null) {
                if (headA.val == p.val) {
                    head.next = new ListNode(p.val);
                    head = head.next;
                }
                p = p.next;
            }
            headA = headA.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        
    }
}

