
import java.util.ArrayList;

public class BinaryTreeZigzagLevelOrderTraversal {

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
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        if (root != null) {
            cur.add(root);
        }
        int dir = 0;
        while (!cur.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            for (int i = 0; i < cur.size(); i++) {
                int idx = dir == 0 ? i : cur.size() - 1 - i;
                temp.add(cur.get(idx).val);
                if (cur.get(i).left != null) {
                    next.add(cur.get(i).left);
                }
                if (cur.get(i).right != null) {
                    next.add(cur.get(i).right);
                }
            }
            ret.add(temp);
            dir = 1 - dir;
            cur = next;
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}

