
public class CloneBinaryTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cpy = new TreeNode(root.val);
        cpy.left = cloneTree(root.left);
        cpy.right = cloneTree(root.right);
        return cpy;
    }

    public static void main(String[] args) {

    }
}