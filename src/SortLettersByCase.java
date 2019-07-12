
public class SortLettersByCase {

    public static void sortLetters(char[] chars) {
        int i = 0;
        while (i < chars.length && Character.isLowerCase(chars[i])) {
            i++;
        }
        for (int j = i + 1; j < chars.length; j++) {
            if (Character.isLowerCase(chars[j])) {
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {

    }
}

