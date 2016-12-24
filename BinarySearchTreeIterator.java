
import java.util.Stack;

public class BinarySearchTreeIterator {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class BSTIterator {
        private Stack<TreeNode> stack;

        //@param root: The root of binary tree.
        public BSTIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
        }

        //@return: True if there has next node, or false
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        //@return: return next node
        public TreeNode next() {
            TreeNode node = stack.pop();
            TreeNode right = node.right;
            while (null != right) {
                stack.push(right);
                right = right.left;
            }
            return node;
        }
    }

    public static void main(String[] args) {

    }
}