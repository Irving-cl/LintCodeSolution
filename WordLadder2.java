
import java.util.*;

public class WordLadder2 {

    private void getPaths(Map<String, Set<String>> asc, List<List<String>> ret, List<String> path, String cur, String end) {
        if (cur.equals(end)) {
            ret.add(new ArrayList<String>(path));
        } else {
            for (String p : asc.get(cur)) {
                path.add(p);
                getPaths(asc, ret, path, p, end);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (start.compareTo(end) == 0) {
            return ret;
        }
        Map<String, Set<String>> asc = new HashMap<String, Set<String>>();
        HashSet<String> vis = new HashSet<String>();
        vis.add(end);
        HashSet<String> cur = new HashSet<String>();
        cur.add(end);
        dict.add(start);
        dict.add(end);
        int len = end.length();
        while (!cur.isEmpty()) {
            HashSet<String> nextLevel = new HashSet<String>();
            for (String str : cur) {
                char[] buf = str.toCharArray();
                for (int i = 0; i < len; i++) {
                    char org = buf[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        buf[i] = c;
                        String adj = new String(buf);
                        if (dict.contains(adj) && !vis.contains(adj)) {
                            nextLevel.add(adj);
                            if (!asc.containsKey(adj)) {
                                asc.put(adj, new HashSet<String>());
                            }
                            asc.get(adj).add(str);
                        }
                    }
                    buf[i] = org;
                }
            }
            for (String str : nextLevel) {
                vis.add(str);
            }
            cur = nextLevel;
            if (cur.contains(end)) {
                break;
            }
        }
        List<String> path = new ArrayList<String>();
        path.add(start);
        getPaths(asc, ret, path, start, end);
        return ret;
    }

    public static void main(String[] args) {

    }
}