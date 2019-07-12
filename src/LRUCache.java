
import java.util.HashMap;

public class LRUCache {

    public class ListNode {
        int key, val;
        ListNode prev, next;
        ListNode(int k, int v) {
            this.key = k;
            this.val = v;
            this.prev = null;
            this.next = null;
        }
    }

    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.dummy = new ListNode(0, 0);
        this.tail = new ListNode(0, 0);
        dummy.next = tail;
        tail.prev = dummy;
        this.capcity = capacity;
        this.map = new HashMap<Integer, ListNode>();
    }

    // @return an integer
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            tail.prev.next = cur;
            cur.prev = tail.prev;
            cur.next = tail;
            tail.prev = cur;
            return cur.val;
        } else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            cur.val = value;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            tail.prev.next = cur;
            cur.prev = tail.prev;
            cur.next = tail;
            tail.prev = cur;
        } else {
            if (capcity <= map.size()) {
                ListNode toDelete = dummy.next;
                toDelete.prev.next = toDelete.next;
                toDelete.next.prev = toDelete.prev;
                map.remove(toDelete.key);
            }
            tail.prev.next = new ListNode(key, value);
            tail.prev.next.prev = tail.prev;
            tail.prev.next.next = tail;
            tail.prev = tail.prev.next;
            map.put(key, tail);
        }
    }

    private ListNode dummy;
    private ListNode tail;
    private int capcity;
    private HashMap<Integer, ListNode> map;

    public static void main(String[] args) {

    }
}
