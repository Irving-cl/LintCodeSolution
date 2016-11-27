
public class ValidNumber {

    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < s.length() && s.charAt(l) == ' ') l++;
        while (r >= 0 && s.charAt(r) == ' ') r--;
        if (l > r) return false;
        s = s.substring(l, r + 1);
        int state = 0;
        boolean valid = true;
        for (int i = 0; i < s.length() && valid; i++) {
            char c = s.charAt(i);
            switch (state) {
                case 0:
                    if ('0' <= c && c <= '9') {
                        state = 1;
                    } else if (c == '+' || c == '-') {
                        state = 4;
                    } else if (c == '.') {
                        state = 2;
                    } else {
                        valid = false;
                    }
                    break;
                case 1:
                    if (c == '.') {
                        state = 7;
                    } else if (c == 'e') {
                        state = 3;
                    } else if (c < '0' || c > '9') {
                        valid = false;
                    }
                    break;
                case 2:
                    if ('0' <= c && c <= '9') {
                        state = 5;
                    } else {
                        valid = false;
                    }
                    break;
                case 3:
                    if (c == '-' || c == '+') {
                        state = 6;
                    } else if ('0' <= c && c <= '9') {
                        state = 5;
                    } else {
                        valid = false;
                    }
                    break;
                case 4:
                    if (c == '.') {
                        state = 2;
                    } else if ('0' <= c && c <= '9') {
                        state = 1;
                    } else {
                        valid = false;
                    }
                    break;
                case 5:
                    if (c < '0' || c > '9') {
                        valid = false;
                    }
                    break;
                case 6:
                    if ('0' <= c && c <= '9') {
                        state = 5;
                    } else {
                        valid = false;
                    }
                    break;
                case 7:
                    if ('0' <= c && c <= '9') {
                        state = 5;
                    } else {
                        valid = false;
                    }
                    break;
            }
        }
        if (state != 1 && state != 7 && state != 5) {
            valid = false;
        }
        return valid;
    }

    public static void main(String[] args) {

    }
}