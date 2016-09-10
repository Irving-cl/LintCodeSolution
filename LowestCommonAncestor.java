
import java.util.ArrayList;

public class LowestCommonAncestor {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class Node {
        TreeNode treeNode;
        int depth;
        public Node(TreeNode treeNode, int d) {
            this.treeNode = treeNode;
            this.depth = d;
        }
    }

    public void dfs(TreeNode root, ArrayList<Node> list, int d) {
        if (root == null) {
            return;
        }
        dfs(root.left, list, d + 1);
        list.add(new Node(root, d));
        dfs(root.right, list, d + 1);
    }

    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        ArrayList<Node> list = new ArrayList<Node>();
        dfs(root, list, 0);
        TreeNode sml = A;
        TreeNode bg = B;
        if (A.val > B.val) {
            sml = B;
            bg = A;
        }
        int i1 = 0;
        while (list.get(i1).treeNode.val != sml.val) {
            i1++;
        }
        Node LCA = list.get(i1);
        for (int i = i1 + 1; i < list.size(); i++) {
            if (list.get(i).depth < LCA.depth) {
                LCA = list.get(i);
            }
            if (list.get(i).treeNode.val == bg.val) {
                break;
            }
        }
        return LCA.treeNode;
    }
}

