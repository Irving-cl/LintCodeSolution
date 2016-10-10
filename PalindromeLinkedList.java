
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;
        while (true) {
            if (fast.next == null) {
                fast = slow.next;
                slow.next = prev;
                break;
            } else if (fast.next.next == null) {
                fast = slow.next.next;
                slow.next = prev;
                break;
            } else {
                fast = fast.next.next;
                ListNode next = slow.next;
                slow.next = prev;
                prev = slow;
                slow = next;
            }
        }
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
