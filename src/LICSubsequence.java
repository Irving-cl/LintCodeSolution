
public class LICSubsequence {

    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public static int longestIncreasingContinuousSubsequence(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int a = 1;
        int b = 1;
        int res = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                a++;
                res = Math.max(a, res);
                b = 1;
            } else if (A[i] < A[i - 1]) {
                b++;
                res = Math.max(b, res);
                a = 1;
            } else {
                a = 1;
                b = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = { 5, 4, 2, 1, 3 };
        int[] test2 = { 5, 1, 2, 3, 4 };
        System.out.println(longestIncreasingContinuousSubsequence(test1));
        System.out.println(longestIncreasingContinuousSubsequence(test2));
    }

}
