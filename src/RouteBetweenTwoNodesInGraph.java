
import java.util.*;

public class RouteBetweenTwoNodesInGraph {

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    };

    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        Set<Integer> visited = new HashSet<Integer>();
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        q.add(s);
        while (!q.isEmpty()) {
            DirectedGraphNode cur = q.poll();
            if (visited.contains(cur.label)) {
                continue;
            }
            visited.add(cur.label);
            if (cur.label == t.label) {
                return true;
            }
            for (DirectedGraphNode adj : cur.neighbors) {
                if (!visited.contains(adj.label)) {
                    q.add(adj);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

