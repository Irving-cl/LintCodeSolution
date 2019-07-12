
public class IdenticalBinaryTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            return (a.val == b.val) && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }
        return false;
    }

    public static void main(String[] args) {
        
    }

}
