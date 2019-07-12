
public class AplusB {
    
    public static int aplusb(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return aplusb((a & b) << 1, a ^ b);
        }
    }

    public static void main(String[] args) {
        System.out.println(aplusb(3, 133));
    }
}
