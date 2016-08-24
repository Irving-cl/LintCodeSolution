
public class IntegerToRoman {

    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        String table[][] = { {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                             {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                             {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                             {"", "M", "MM", "MMM", "", "", "", "", "", ""} };
        String ans = "";
        int i = 0;
        while (n > 0) {
            ans = table[i++][n % 10] + ans;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}