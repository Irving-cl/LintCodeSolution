
public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        int farthest = 0;
        for (int i = 0; i < A.length; i++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, i + A[i]);
            }
        }
        return farthest >= A.length - 1;
    }
}

