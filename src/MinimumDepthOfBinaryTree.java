
public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int d = Integer.MAX_VALUE;
            if (root.left != null) {
                d = Math.min(d, minDepth(root.left) + 1);
            }
            if (root.right != null) {
                d = Math.min(d, minDepth(root.right) + 1);
            }
            return d;
        }
    }

    public static void main(String[] args) {

    }
}
