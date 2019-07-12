
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                for (int j = left; j < map.get(c); j++) {
                    if (map.containsKey(s.charAt(j))) {
                        map.remove(s.charAt(j));
                    }
                }
                left = map.get(c) + 1;
                map.put(c, i);
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
