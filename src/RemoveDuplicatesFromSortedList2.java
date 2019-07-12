
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedList2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        ListNode p = head;
        while (p != null) {
            if (cnt.containsKey(p.val)) {
                cnt.put(p.val, cnt.get(p.val) + 1);
            } else {
                cnt.put(p.val, 1);
            }
            p = p.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode pp = dummy;
        dummy.next = head;
        p = head;
        while (p != null) {
            if (cnt.get(p.val) < 2) {
                pp.next = p;
                pp = pp.next;
            }
            p = p.next;
        }
        pp.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

