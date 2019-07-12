import java.util.ArrayList;
import java.util.List;

public class SubTree {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public static boolean isSubtree(TreeNode T1, TreeNode T2) {
        subTreeDepth = depth(T2);
        candidates = new ArrayList<TreeNode>();
        depth1(T1);
        for (TreeNode candidate : candidates) {
            if (isIdentical(candidate, T2)) {
                return true;
            }
        }
        return false;
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
    
    private static int depth1(TreeNode root) {
        int d = 0;
        if (root != null) {
            d = Math.max(depth1(root.left), depth1(root.right)) + 1;
        }
        if (d == subTreeDepth) {
            candidates.add(root);
        }
        return d;
    }
    
    private static boolean isIdentical(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        } else if (T1 != null && T2 != null) {
            return T1.val == T2.val && isIdentical(T1.left, T2.left) && isIdentical(T1.right, T2.right);
        } else {
            return false;
        }
    }
    
    private static List<TreeNode> candidates;
    private static int subTreeDepth;
    
    public static void main(String[] args) {
        
    }
}