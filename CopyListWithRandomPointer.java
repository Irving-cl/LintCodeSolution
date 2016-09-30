
public class CopyListWithRandomPointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        RandomListNode copyHead = null;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            copy.random = p.random;
            p.next = copy;
            if (p == head) {
                copyHead = copy;
            }
            p = copy.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            RandomListNode temp = p.next.next;
            if (p.next.next != null) {
                p.next.next = p.next.next.next;
            }
            p = temp;
        }
        return copyHead;
    }

    public static void main(String[] args) {

    }
}

