
import java.util.*;

public class TopologicalSorting {

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    };

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        HashMap<Integer, DirectedGraphNode> map = new HashMap<Integer, DirectedGraphNode>();
        ArrayList<Integer> topoOrder = new ArrayList<Integer>();
        for (DirectedGraphNode dgn : graph) {
            map.put(dgn.label, dgn);
            if (!indegree.containsKey(dgn.label)) {
                indegree.put(dgn.label, 0);
            }
            for (DirectedGraphNode neighbour : dgn.neighbors) {
                if (indegree.containsKey(neighbour.label)) {
                    indegree.put(neighbour.label, indegree.get(neighbour.label) + 1);
                } else {
                    indegree.put(neighbour.label, 1);
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(map.get(entry.getKey()));
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode cur = q.poll();
            topoOrder.add(cur.label);
            for (DirectedGraphNode adj : cur.neighbors) {
                indegree.put(adj.label, indegree.get(adj.label) - 1);
                if (indegree.get(adj.label) == 0) {
                    q.add(adj);
                }
            }
        }
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < topoOrder.size(); i++) {
            idx.put(topoOrder.get(i), i);
        }
        for (int i = 0; i < graph.size(); i++) {
            int rightIdx = idx.get(graph.get(i).label);
            if (rightIdx != i) {
                DirectedGraphNode temp = graph.get(i);
                graph.set(i, graph.get(rightIdx));
                graph.set(rightIdx, temp);
                i--;
            }
        }System.out.println();
        return graph;
    }

    public static void main(String[] args) {

    }
}
