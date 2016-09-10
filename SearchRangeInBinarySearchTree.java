
import java.util.ArrayList;

public class SearchRangeInBinarySearchTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public void help(TreeNode root, ArrayList<Integer> list, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val < k1) {
            help(root.right, list, k1, k2);
        } else if (root.val > k2) {
            help(root.left, list, k1, k2);
        } else {
            help(root.left, list, k1, k2);
            list.add(root.val);
            help(root.right, list, k1, k2);
        }
    }

    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        help(root, arrayList, k1, k2);
        return arrayList;
    }
}

