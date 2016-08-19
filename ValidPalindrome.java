
public class ValidPalindrome {

    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        char[] buf = new char[s.length()];
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                buf[len++] = Character.toLowerCase(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                buf[len++] = s.charAt(i);
            }
        }
        for (int i = 0; i < len / 2; i++) {
            if (buf[i] != buf[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}