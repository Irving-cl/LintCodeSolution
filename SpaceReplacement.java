
public class SpaceReplacement {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        if (string == null || length == 0) {
            return 0;
        }
        int len = 0;
        char[] buf = new char[string.length];
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                buf[len] = '%';
                buf[len + 1] = '2';
                buf[len + 2] = '0';
                len += 3;
            } else {
                buf[len++] = string[i];
            }
        }
        for (int i = 0; i < len; i++) {
            string[i] = buf[i];
        }
        return len;
    }

    public static void main(String[] args) {

    }
}

