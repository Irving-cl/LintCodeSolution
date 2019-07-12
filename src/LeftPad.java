
public class LeftPad {

    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        if (size <= originalStr.length()) {
            return originalStr;
        }
        char[] buf = new char[size - originalStr.length()];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = ' ';
        }
        String pad = new String(buf);
        pad = pad + originalStr;
        return pad;
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        if (size <= originalStr.length()) {
            return originalStr;
        }
        char[] buf = new char[size - originalStr.length()];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        String pad = new String(buf);
        pad = pad + originalStr;
        return pad;
    }

    public static void main(String[] args) {
        
    }

}
