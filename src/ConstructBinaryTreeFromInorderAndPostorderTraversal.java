
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode help(int left, int right, int idx, int[] inorder, int[] postorder) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(inorder[left]);
        } else {
            int k = left;
            while (inorder[k] != postorder[idx]) {
                k++;
            }
            TreeNode root = new TreeNode(inorder[k]);
            root.right = help(k + 1, right, idx - 1, inorder, postorder);
            root.left = help(left, k - 1, idx - 1 - (right - k), inorder, postorder);
            return root;
        }
    }

    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return help(0, inorder.length - 1, inorder.length - 1, inorder, postorder);
    }

    public static void main(String[] args) {

    }
}

