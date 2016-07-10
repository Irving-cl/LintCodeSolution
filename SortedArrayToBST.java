package com.algorithm;

public class SortedArrayToBST {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode help(int[] A, int start, int end) {
        if (start == end) {
            return new TreeNode(A[start]);
        } else if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode cur = new TreeNode(A[mid]);
        cur.left = help(A, start, mid - 1);
        cur.right = help(A, mid + 1, end);
        return cur;
    }

    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A.length == 0) {
            return null;
        }
        return help(A, 0, A.length - 1);
    }

    public static void main(String[] args) {

    }
}
