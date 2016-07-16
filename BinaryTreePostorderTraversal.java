
import java.util.ArrayList;

public class BinaryTreePostorderTraversal {

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
        help(root.left, a);
        help(root.right, a);
        a.add(root.val);
    }

    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        help(root, ret);
        return ret;
    }

    public static void main(String[] args) {

    }
}
