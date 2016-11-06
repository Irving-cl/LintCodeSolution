
public class ValidateBinarySearchTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class Node {
        public int min;
        public int max;
        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public boolean flag;

    public Node help(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Node(root.val, root.val);
        } else if (root.left == null) {
            Node right = help(root.right);
            if (right.min <= root.val) {
                flag = false;
            }
            return new Node(root.val, right.max);
        } else if (root.right == null) {
            Node left = help(root.left);
            if (left.max >= root.val) {
                flag = false;
            }
            return new Node(left.min, root.val);
        } else {
            Node left = help(root.left);
            Node right = help(root.right);
            if (left.max >= root.val || right.min <= root.val) {
                flag = false;
            }
            return new Node(left.min, right.max);
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        flag = true;
        if (root != null) {
            help(root);
        }
        return flag;
    }

    public static void main(String[] args) {

    }
}

