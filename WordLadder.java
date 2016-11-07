

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.compareTo(end) == 0) {
            return 1;
        }
        Set<String> vis = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        vis.add(start);
        int len = start.length();
        int lad = 2;
        int cntCl = 1;
        int cntNl = 0;
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            String cur = queue.poll();
            char[] buf = cur.toCharArray();
            for (int i = 0; i < len && !found; i++) {
                char org = buf[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    buf[i] = c;
                    String adj = new String(buf);
                    if (adj.equals(end)) {
                        found = true;
                        break;
                    } else if (dict.contains(adj) && !vis.contains(adj)) {
                        vis.add(adj);
                        queue.add(adj);
                        cntNl++;
                    }
                }
                buf[i] = org;
            }
            if (--cntCl == 0 && !found) {
                lad++;
                cntCl = cntNl;
                cntNl = 0;
            }
        }
        return lad;
    }

    public static void main(String[] args) {

    }
}

