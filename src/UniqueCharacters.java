
public class UniqueCharacters {

    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        boolean[] ascii = new boolean[128];
        for (int i = 0; i < 128; i++) {
            ascii[i] = false;
        }
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (ascii[c]) {
                return false;
            } else {
                ascii[c] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
