
public class DeleteNodeInLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode last = node;
        while (node.next != null) {
            node.val = node.next.val;
            last = node;
            node = node.next;
        }
        last.next = null;
    }

    public static void main(String[] args) {

    }

}
