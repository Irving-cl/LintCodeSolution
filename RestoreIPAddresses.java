
import java.util.ArrayList;

public class RestoreIPAddresses {

    public void help(int seg, int idx, ArrayList<Integer> cur, ArrayList<String> res, String s) {
        if (seg == 0) {
            if (idx == s.length()) {
                res.add(cur.get(0) + "." + cur.get(1) + "." + cur.get(2) + "." + cur.get(3));
            }
        } else {
            int len = s.length();
            if (len - idx <= seg * 3) {
                for (int i = 0; i < 3 && i + idx < len; i++) {
                    String sub = s.substring(idx, idx + i + 1);
                    if (sub.length() > 1 && sub.charAt(0) == '0') {
                        continue;
                    }
                    Integer temp = Integer.valueOf(sub);
                    if (temp < 256) {
                        cur.add(temp);
                        help(seg - 1, idx + i + 1, cur, res, s);
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        }
    }

    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<String> res = new ArrayList<String>();
        help(4, 0, cur, res, s);
        return res;
    }

    public static void main(String[] args) {

    }
}