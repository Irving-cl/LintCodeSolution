import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal2 {

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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return ret;
        }
        ArrayList<TreeNode> q1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> q2 = new ArrayList<TreeNode>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            if (q1.isEmpty()) {
                for (TreeNode t : q2) {
                    temp.add(t.val);
                    if (t.left != null) {
                        q1.add(t.left);
                    }
                    if (t.right != null) {
                        q1.add(t.right);
                    }
                }
                q2.clear();
            } else {
                for (TreeNode t : q1) {
                    temp.add(t.val);
                    if (t.left != null) {
                        q2.add(t.left);
                    }
                    if (t.right != null) {
                        q2.add(t.right);
                    }
                }
                q1.clear();
            }
            ret.add(temp);
        }
        for (int i = 0; i < ret.size() / 2; i++) {
            ArrayList<Integer> temp = ret.get(i);
            ret.set(i, ret.get(ret.size() - i - 1));
            ret.set(ret.size() - i - 1, temp);
        }
        return ret;
    }

    public static void main(String[] args) {
        
    }
}