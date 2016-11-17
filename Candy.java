
public class Candy {

    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dst1 = new int[n];
        int[] dst2 = new int[n];
        for (int i = 0; i < n; i++) {
            dst1[i] = dst2[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dst1[i] = dst1[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dst2[i] = dst2[i + 1] + 1;
            }
        }
        int mn = 0;
        for (int i = 0; i < n; i++) {
            mn += Math.max(dst1[i], dst2[i]);
        }
        return mn;
    }

    public static void main(String[] args) {

    }
}