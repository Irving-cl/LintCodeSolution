
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BuildingOutline {

    public class Edge implements Comparable<Edge> {
        int     pos;
        int     height;
        boolean start;
        Edge(int p, int h, boolean s) {
            this.pos = p;
            this.height = h;
            this.start = s;
        }
        @Override
        public int compareTo(Edge o) {
            if (this.pos != o.pos) return Integer.compare(this.pos, o.pos);
            if (this.start && o.start) return Integer.compare(o.height, this.height);
            if (!this.start && !o.start) return Integer.compare(this.height, o.height);
            return this.start ? -1 : 1;
        }
    }

    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return tmp;
        }
        Edge[] edges = new Edge[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            edges[i * 2] = new Edge(buildings[i][0], buildings[i][2], true);
            edges[i * 2+1] = new Edge(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(edges);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if (edge.start) {
                if (heap.isEmpty() || edge.height > heap.peek()) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(edge.pos);
                    list.add(edge.height);
                    tmp.add(list);
                }
                heap.add(edge.height);
            } else {
                heap.remove(edge.height);
                if (heap.isEmpty() || edge.height > heap.peek()) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(edge.pos);
                    if (heap.isEmpty()) {
                        list.add(0);
                    } else {
                        list.add(heap.peek());
                    }
                    tmp.add(list);
                }
            }
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < tmp.size() - 1; i++) {
            int pos1 = tmp.get(i).get(0);
            int h1 = tmp.get(i).get(1);
            if (h1 > 0) {
                int pos2 = tmp.get(i + 1).get(0);
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(pos1);
                list.add(pos2);
                list.add(h1);
                ret.add(list);
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}