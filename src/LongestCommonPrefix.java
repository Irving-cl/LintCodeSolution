
public class LongestCommonPrefix {

    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int len = 0;
        while (true) {
            boolean flag = true;
            if (len + 1 > strs[0].length()) {
                flag = false;
                break;
            }
            char c = strs[0].charAt(len);
            for (int i = 1; i < strs.length; i++) {
                if (len + 1 > strs[i].length() || strs[i].charAt(len) != c) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            len++;
        }
        return strs[0].substring(0, len);
    }

    public static void main(String[] args) {

    }
}

