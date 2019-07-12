
public class SegmentTreeBuild {

    public static class SegmentTreeNode {
        public int start, end;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }

    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public static SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, start);
        } else {
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
            return root;
        }
    }

    public static void main(String[] args) {

    }
}

