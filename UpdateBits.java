
public class UpdateBits {

    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        int mask = ((~0) << (j + 1)) | ((1 << i) - 1);
        if (j == 31) {
            mask = (1 << i) - 1;
        }
        n &= mask;
        return n | (m << i);
    }

    public static void main(String[] args) {

    }
}

