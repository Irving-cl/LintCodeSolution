
import java.util.*;

public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        if (node != null) {
            q.add(node);
        } else {
            return null;
        }
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            if (visited.contains(cur.label)) {
                continue;
            }
            visited.add(cur.label);
            UndirectedGraphNode copy = null;
            if (!map.containsKey(cur.label)) {
                copy = new UndirectedGraphNode(cur.label);
                map.put(cur.label, copy);
            } else {
                copy = map.get(cur.label);
            }
            for (UndirectedGraphNode adj : cur.neighbors) {
                UndirectedGraphNode copyAdj = null;
                if (!map.containsKey(adj.label)) {
                    copyAdj = new UndirectedGraphNode(adj.label);
                    map.put(adj.label, copyAdj);
                } else {
                    copyAdj = map.get(adj.label);
                }
                copy.neighbors.add(copyAdj);
                if (!visited.contains(adj.label)) {
                    q.add(adj);
                }
            }
        }
        return map.get(node.label);
    }

    public static void main(String[] args) {

    }
}

