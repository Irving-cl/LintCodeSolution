
public class TwoStringsAreAnagrams {

    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] tb = new int[128];
        for (int i = 0; i < s.length(); i++) {
            tb[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            tb[t.charAt(i)]--;
            if (tb[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
};