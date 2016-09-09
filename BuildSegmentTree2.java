
public class BuildSegmentTree2 {

    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }

    public SegmentTreeNode help(int[] A, int l, int r) {
        if (l == r) {
            return new SegmentTreeNode(l, l, A[l]);
        } else {
            SegmentTreeNode cur = new SegmentTreeNode(l, r, 0);
            int mid = (l + r) >> 1;
            cur.left = help(A, l, mid);
            cur.right = help(A, mid + 1, r);
            cur.max = Math.max(cur.left.max, cur.right.max);
            return cur;
        }
    }

    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        return help(A, 0, A.length - 1);
    }

    public static void main(String[] args) {

    }
}

