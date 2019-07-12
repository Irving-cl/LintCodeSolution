
public class RotateString {

    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        int len = str.length;
        if (len == 0) {
            return;
        }
        offset %= len;
        char[] buf = new char[offset];
        for (int i = len - offset, j = 0; i < len; i++, j++) {
            buf[j] = str[i];
        }
        for (int i = len - offset - 1; i >= 0; i--) {
            str[i + offset] = str[i];
        }
        for (int i = 0; i < offset; i++) {
            str[i] = buf[i];
        }
    }

    public static void main(String[] args) {
        
    }
};