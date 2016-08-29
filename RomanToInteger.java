
public class RomanToInteger {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        int[] tb = new int[26];
        tb['I' - 'A'] = 1;
        tb['V' - 'A'] = 5;
        tb['X' - 'A'] = 10;
        tb['L' - 'A'] = 50;
        tb['C' - 'A'] = 100;
        tb['D' - 'A'] = 500;
        tb['M' - 'A'] = 1000;
        int last = Integer.MIN_VALUE;
        int val = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = tb[s.charAt(i) - 'A'];
            val += cur >= last ? cur : -cur;
            last = cur;
        }
        return val;
    }

    public static void main(String[] args) {

    }
}

