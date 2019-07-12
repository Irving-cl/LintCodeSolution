
public class InsertNodeInBST {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public void help(TreeNode root, TreeNode node) {
        if (node.val < root.val) {
            if (root.left == null) {
                root.left = node;
                return;
            }
            help(root.left, node);
        } else if (node.val > root.val) {
            if (root.right == null) {
                root.right = node;
                return;
            }
            help(root.right, node);
        }
    }

    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        help(root, node);
        return root;
    }

    public static void main(String[] args) {
        
    }

}
