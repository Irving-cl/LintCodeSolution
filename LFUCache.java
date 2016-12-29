
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

    public class node {
        int fre;
        int key;
        int val;
        int seq;
        public node(int f, int k, int v,int s) {
            this.fre = f;
            this.key = k;
            this.val = v;
            this.seq = s;
        }
    }

    private PriorityQueue<node> pq;
    private Map<Integer, node> map;
    private int capacity;
    private int idx;

    // @param capacity, an integer
    public LFUCache(int capacity) {
        pq = new PriorityQueue<node>(1, new Comparator<node>(){
            public int compare(node n1,node n2) {
                if (n1.fre != n2.fre) {
                    return n1.fre - n2.fre;
                } else {
                    return n1.seq - n2.seq;
                }
            }
        });
        map = new HashMap<Integer, node>();
        this.capacity = capacity;
        idx = 0;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            node tmp = map.get(key);
            map.remove(key);
            pq.remove(tmp);
            tmp.fre++;
            tmp.val = value;
            map.put(key, tmp);
            pq.add(tmp);
        } else {
            idx++;
            if (this.capacity == pq.size()) {
                node toRemove = pq.poll();
                map.remove(toRemove.key);
            }
            node toSet = new node(1, key, value, idx);
            map.put(key, toSet);
            pq.add(toSet);
        }
    }

    public int get(int key) {
        idx++;
        if (!map.containsKey(key)) {
            return -1;
        } else {
            node tmp = map.get(key);
            map.remove(key);
            pq.remove(tmp);
            tmp.fre++;
            tmp.seq = idx;
            map.put(key, tmp);
            pq.add(tmp);
        }
        return map.get(key).val;
    }

    public static void main(String[] args) {

    }
}