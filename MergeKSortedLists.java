
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        Queue<ListNode> pq = new PriorityQueue<ListNode>(1000, comparator);
        int nullCnt = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                pq.add(lists.get(i));
            } else {
                nullCnt++;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (nullCnt < lists.size()) {
            ListNode cur = pq.poll();
            p.next = cur;
            p = p.next;
            if (cur.next == null) {
                nullCnt++;
            } else {
                pq.add(cur.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

