
public class FlattenBinaryTreeToLinkedList {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
           this.val = val;
           this.left = this.right = null;
        }
    }

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {

    }

}
