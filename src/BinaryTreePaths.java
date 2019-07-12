import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private List<String> paths;

    public void help(TreeNode root, String path) {
        if (root != null) {
            path += String.valueOf(root.val);
            String temp = new String(path);
            if (root.left == null && root.right == null) {
                paths.add(temp);
            } else {
                temp += "->";
                if (root.left != null) {
                    help(root.left, temp);
                }
                if (root.right != null) {
                    help(root.right, temp);
                }
            }
        }
    }

    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList<String>();
        help(root, "");
        return paths;
    }

    public static void main(String[] args) {

    }

}
