
public class ReverseWordsInAString {

    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String rs = new String();
        if (words.length == 0) {
            return rs;
        }
        rs += words[words.length - 1];
        for (int i = words.length - 2; i >= 0; i--) {
            rs += " " + words[i];
        }
        return rs;
    }

    public static void main(String[] args) {

    }
}
