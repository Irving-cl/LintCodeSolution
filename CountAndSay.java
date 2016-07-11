
public class CountAndSay {

    /**
     * @param n the nth
     * @return the nth sequence
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String parent = countAndSay(n - 1);
        String cur = new String("");
        int i = 0;
        int j = 0;
        while (i < parent.length()) {
            while (j < parent.length() && parent.charAt(i) == parent.charAt(j)) {
                j++;
            }
            cur += String.valueOf(j - i) + parent.charAt(i);
            i = j;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(7));
    }

}
