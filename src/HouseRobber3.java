
public class HouseRobber3 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int x) { val = x; }
    }

    public class Choice {
        public int a;
        public int b;
        public Choice(int aa, int bb) {
            a = aa;
            b = bb;
        }
    }

    Choice help(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Choice(root.val, 0);
        }
        Choice left = null;
        Choice right = null;
        if (root.left != null) {
            left = help(root.left);
        }
        if (root.right != null) {
            right = help(root.right);
        }
        int a = root.val + (left != null ? left.b : 0) + (right != null ? right.b : 0);
        int b = (left != null ? left.a : 0) + (right != null ? right.a : 0);
        return new Choice(a, b);
    }

    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Choice c = help(root);
        return Math.max(c.a, c.b);
    }

    public static void main(String[] args) {

    }
}
