
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        String srlz = new String("{");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != root) {
                srlz += ",";
            }
            if (cur == null) {
                srlz += "#";
            } else {
                srlz += cur.val;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        srlz += "}";
        return srlz;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        if (nodes[0].compareTo("#") == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        TreeNode cur = root;
        int idx = 1;
        int state = 0;
        while (idx < nodes.length) {
            if (state == 0) {
                if (nodes[idx].compareTo("#") != 0) {
                    cur.left = new TreeNode(Integer.valueOf(nodes[idx]));
                    queue.add(cur.left);
                } else {
                    cur.left = null;
                }
                state++;
            } else {
                if (nodes[idx].compareTo("#") != 0) {
                    cur.right = new TreeNode(Integer.valueOf(nodes[idx]));
                    queue.add(cur.right);
                } else {
                    cur.right = null;
                }
                cur = queue.poll();
                state = 0;
            }
            idx++;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}