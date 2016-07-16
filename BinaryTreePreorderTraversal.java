
import java.util.ArrayList;

public class BinaryTreePreorderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public void help(TreeNode root, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }
        a.add(root.val);
        help(root.left, a);
        help(root.right, a);
    }

    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList ret = new ArrayList<Integer>();
        help(root, ret);
        return ret;
    }

    public static void main(String[] args) {

    }
}
