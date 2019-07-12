
public class SegmentTreeModify {

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

    /**
     *@param root, index, value: The root of segment tree and
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        if (root.right == null) {
            root.max = value;
            return;
        } else if (root.right.start <= index) {
            modify(root.right, index, value);
        } else {
            modify(root.left, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
    }

    public static void main(String[] args) {

    }
}

