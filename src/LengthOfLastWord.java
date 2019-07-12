
public class LengthOfLastWord {

    /**
     * @param s A string
     * @return the length of last word
     */
    public static int lengthOfLastWord(String s) {
        int len = 0;
        int idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }
        for (int i = idx; i >= 0 && s.charAt(i) != ' '; i--) {
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        String test1 = new String("Hello World");
        String test2 = new String("Hehe");
        String test3 = new String("b a ");
        System.out.println(lengthOfLastWord(test1));
        System.out.println(lengthOfLastWord(test2));
        System.out.println(lengthOfLastWord(test3));
    }

}
