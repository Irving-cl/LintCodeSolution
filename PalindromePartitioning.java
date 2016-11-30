
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;j--;
        }
        return true;
    }

    public void dfs(int idx, String s, List<String> cur, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<String>(cur));
        } else {
            for (int i = idx; i < s.length(); i++) {
                if (isPalindrome(s, idx, i)) {
                    cur.add(s.substring(idx, i + 1));
                    dfs(i + 1, s, cur, res);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        dfs(0, s, cur, res);
        return res;
    }

    public static void main(String[] args) {

    }
}