
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {

    public class Node implements Comparable<Node> {
        public int row;
        public int idx;
        public int val;
        public Node(int row, int idx, int val) {
            this.row = row;
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (this.val < o.val) {
                return -1;
            } else if (this.val > o.val) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (int i = 0; i < m; i++) {
            pq.add(new Node(i, 0, matrix[i][0]));
        }
        for (int i = 0; i < k - 1; i++) {
            Node cur = pq.poll();
            if (cur.idx < n - 1) {
                pq.add(new Node(cur.row, cur.idx + 1, matrix[cur.row][cur.idx + 1]));
            }
        }
        return pq.peek().val;
    }

    public static void main(String[] args) {

    }
}

