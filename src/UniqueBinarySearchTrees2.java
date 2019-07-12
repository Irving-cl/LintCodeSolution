
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<TreeNode> createTree(int start, int end) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        for (int k = start; k <= end; k++) {
            List<TreeNode> left = createTree(start, k - 1);
            List<TreeNode> right = createTree(k + 1, end);
            for (int i = 0; i < left.size(); i++) {
                for (int j = 0; j < right.size(); j++) {
                    TreeNode root = new TreeNode(k);
                    root.left = left.get(i);
                    root.right = right.get(j);
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        return createTree(1, n);
    }

    public static void main(String[] args) {

    }
}

