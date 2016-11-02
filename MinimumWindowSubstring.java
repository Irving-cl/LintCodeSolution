
public class MinimumWindowSubstring {

    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     * Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        int[] cnt = new int[256];
        int[] trg = new int[256];
        int begin = -1;
        int start = 0;
        int end = 0;
        int found = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < target.length(); i++) {
            trg[target.charAt(i)]++;
        }
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (cnt[c] < trg[c]) {
                found++;
            }
            cnt[c]++;
            if (found == target.length()) {
                while (cnt[source.charAt(start)] > trg[source.charAt(start)]) {
                    cnt[source.charAt(start)]--;
                    start++;
                }
                if (i - start < len) {
                    len = i - start;
                    begin = start;
                    end = i;
                }
                cnt[source.charAt(start)]--;
                found--;
                start++;
            }
        }
        return begin == -1 ? "" : source.substring(begin, end + 1);
    }

    public static void main(String[] args) {

    }
}

