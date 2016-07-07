
public class AddBinary {
    
    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String c = a;
            a = b;
            b = c;
        }
        int diff = a.length() - b.length();
        int i = a.length() - 1;
        char pro = 0;
        String res = "";
        for ( ; i >= 0; i--) {
            int temp = pro + a.charAt(i) - '0';
            if (i >= diff) {
                temp += b.charAt(i - diff) - '0';
            }
            res = String.valueOf((char) temp % 2) + res;
            if (temp > 1) {
                pro = 1;
            } else {
                pro = 0;
            }
        }
        if (pro == 1) {
            res = "1" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("100", "11"));
        System.out.println(addBinary("101", "111"));
    }
}
