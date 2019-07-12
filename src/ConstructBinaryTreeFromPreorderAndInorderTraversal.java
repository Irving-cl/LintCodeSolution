
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode help(int[] preorder, int[] inorder, int l, int r, int rootIdx) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return new TreeNode(preorder[rootIdx]);
        } else {
            TreeNode root = new TreeNode(preorder[rootIdx]);
            int x = l;
            while (x <= r && inorder[x] != root.val) {
                x++;
            }
            root.left = help(preorder, inorder, l, x - 1, rootIdx + 1);
            root.right = help(preorder, inorder, x + 1, r, rootIdx + 1 + x - l);
            return root;
        }
    }

    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, inorder, 0, inorder.length - 1, 0);
    }

    public static void main(String[] args) {

    }
}

