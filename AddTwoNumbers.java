
public class AddTwoNumbers {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;      
        }
    }
    
    public static ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int digitSum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                digitSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                digitSum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(digitSum > 9 ? digitSum - 10 : digitSum);
            cur = cur.next;
            digitSum = digitSum > 9 ? 1 : 0;
        }
        if (digitSum > 0) {
            cur.next = new ListNode(digitSum);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
