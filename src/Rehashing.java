
public class Rehashing {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
         }
    }

    public void insert(ListNode[] hashTable, int i, int val) {
        if (hashTable[i] == null) {
            hashTable[i] = new ListNode(val);
        } else {
            ListNode listNode = hashTable[i];
            while (listNode.next != null) {
                listNode = listNode.next;
            }
            listNode.next = new ListNode(val);
        }
    }

    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        ListNode[] rehash = new ListNode[hashTable.length * 2];
        int capcity = rehash.length;
        for (int i = 0; i < rehash.length; i++) {
            rehash[i] = null;
        }
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                ListNode temp = hashTable[i];
                while (temp != null) {
                    insert(rehash, (temp.val % capcity + capcity) % capcity, temp.val);
                    temp = temp.next;
                }
            }
        }
        return rehash;
    }

    public static void main(String[] args) {

    }
}
