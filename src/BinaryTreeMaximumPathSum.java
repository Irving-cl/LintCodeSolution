
public class BinaryTreeMaximumPathSum {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class Node {
        public int a;
        public int b;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public Node help(TreeNode root) {
        Node cur = new Node(root.val, root.val);
        if (root.left == null && root.right == null) {
            return cur;
        } else if (root.left == null) {
            Node r = help(root.right);
            cur.b = Math.max(cur.b, r.b + root.val);
            cur.a = Math.max(cur.a, r.a);
            cur.a = Math.max(cur.a, r.b + root.val);
            return cur;
        } else if (root.right == null) {
            Node l = help(root.left);
            cur.b = Math.max(cur.b, l.b + root.val);
            cur.a = Math.max(cur.a, l.a);
            cur.a = Math.max(cur.a, l.b + root.val);
            return cur;
        } else {
            Node l = help(root.left);
            Node r = help(root.right);
            cur.b = Math.max(cur.b, l.b + root.val);
            cur.b = Math.max(cur.b, r.b + root.val);
            cur.a = Math.max(cur.a, l.a);
            cur.a = Math.max(cur.a, r.a);
            cur.a = Math.max(cur.a, root.val + l.b);
            cur.a = Math.max(cur.a, root.val + r.b);
            cur.a = Math.max(cur.a, root.val + l.b + r.b);
            return cur;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Node node = help(root);
        return Math.max(node.a, node.b);
    }

    public static void main(String[] args) {

    }
}
