
public class RemoveNodeInBinarySearchTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        dummy.left = root;
        dummy.right = null;

        TreeNode p = dummy;
        TreeNode target = null;
        while (p.left != null || p.right != null) {
            if (value < p.val) {
                if (p.left != null) {
                    if (p.left.val == value) {
                        target = p.left;
                        break;
                    } else {
                        p = p.left;
                    }
                } else {
                    break;
                }
            } else {
                if (p.right != null) {
                    if (p.right.val == value) {
                        target = p.right;
                        break;
                    } else {
                        p = p.right;
                    }
                } else {
                    break;
                }
            }
        }

        if (target == null) {
            return root;
        }

        if (target.right == null) {
            if (target == p.left) {
                p.left = target.left;
            } else {
                p.right = target.left;
            }
        } else {
            TreeNode rightChild = target.right;
            TreeNode leftSubTree = rightChild.left;
            rightChild.left = target.left;
            TreeNode tmp = rightChild.left;
            if (tmp != null) {
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
            }
            if (tmp != null) {
                tmp.right = leftSubTree;
            } else {
                rightChild.left = leftSubTree;
            }
            if (target == p.left) {
                p.left = rightChild;
            } else {
                p.right = rightChild;
            }
        }
        return dummy.left;
    }

    public static void main(String[] args) {

    }
}