import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Node {
        int l, r, val;
        Node left, right;
        Node(int l, int r) {
            this.l = l;
            this.r = r;
            this.val = 0;
            this.left = null;
            this.right = null;
        }
    }

    static Node build(int l, int r) {
        Node root = new Node(l, r);
        if (l + 1 < r) {
            int mid = (l + r) >> 1;
            root.left = build(l, mid);
            root.right = build(mid, r);
        }
        return root;
    }

    static void rangeFill(int l, int r, int val, Node root) {
        if (l == root.l && r == root.r && root.val != 1) {
            root.val = val;
        } else if (root.val != 1) {
            int mid = (root.l + root.r) >> 1;
            if (l >= mid) {
                rangeFill(l, r, val, root.right);
            } else if (r <= mid) {
                rangeFill(l, r, val, root.left);
            } else {
                rangeFill(l, mid, val, root.left);
                rangeFill(mid, r, val, root.right);
            }
            if (root.left.val == 1 && root.right.val == 1) {
                root.val = 1;
            }
        }
    }
    
    static void segTraverse(Node root, List<Interval> res) {
        if (root.val == 1) {
            if (!res.isEmpty() && root.l == res.get(res.size() - 1).end) {
                res.get(res.size() - 1).end = root.r;
            } else {
                res.add(new Interval(root.l, root.r));
            }
        } else if (root.val == 2 && (res.isEmpty() || root.l != res.get(res.size() - 1).end)){
            res.add(new Interval(root.l, root.l));
        } else {
            if (root.left != null) {
                segTraverse(root.left, res);
            }
            if (root.right != null) {
                segTraverse(root.right, res);
            }
        }
    }
    
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        int top = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;
        for (Interval interval : intervals) {
            top = Math.max(top, interval.end);
            down = Math.min(down, interval.start);
        }
        Node root = build(down, top);
        for (Interval interval : intervals) {
            if (interval.start != interval.end) {
                rangeFill(interval.start, interval.end, 1, root);
            } else {
                rangeFill(interval.start, interval.end + 1, 2, root);
            }
        }
        segTraverse(root, list);
        return list;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(4, 5));
        list.add(new Interval(2, 4));
        list.add(new Interval(4, 6));
        list.add(new Interval(3, 4));
        list.add(new Interval(0, 0));
        list.add(new Interval(1, 1));
        list.add(new Interval(3, 5));
        list.add(new Interval(2, 2));
        List<Interval> res = merge(list);
        for (Interval interval : res) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
