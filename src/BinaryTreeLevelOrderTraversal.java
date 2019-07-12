
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {

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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lo = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return lo;
        }
        ArrayList<TreeNode> last = new ArrayList<TreeNode>();
        last.add(root);
        while (!last.isEmpty()) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            for (TreeNode t : last) {
                cur.add(t.val);
                if (t.left != null) temp.add(t.left);
                if (t.right != null) temp.add(t.right);
            }
            lo.add(cur);
            last = temp;
        }
        return lo;
    }

    public static void main(String[] args) {

    }
}

