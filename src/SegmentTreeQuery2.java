
public class SegmentTreeQuery2 {

    public class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }

    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > root.end || end < root.start) {
            return 0;
        }
        if (start <= root.start && end >= root.end) {
            return root.count;
        }
        return query(root.left, start, end) + query(root.right, start, end);
    }

    public static void main(String[] args) {

    }
}

