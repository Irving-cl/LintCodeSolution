
public class MaximumGap {

    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        int len = nums.length;
        if (len < 2) return 0;
        for (int i = 0; i < len; i++) {
            mx = Math.max(mx, nums[i]);
            mn = Math.min(mn, nums[i]);
        }
        int gap = (mx - mn) / (len - 1) + 1;
        int[] mnn = new int[len];
        int[] mxx = new int[len];
        for (int i = 0; i < len; i++) {
            mnn[i] = -1;
            mxx[i] = 0;
        }
        for (int i = 0; i < len; i++) {
            int idx = (nums[i] - mn) / gap;
            if (mnn[idx] < 0) mnn[idx] = nums[i];
            else mnn[idx] = Math.min(mnn[idx], nums[i]);
            mxx[idx] = Math.max(mxx[idx], nums[i]);
        }
        int start = mxx[0];
        int end = mnn[0];
        int ans = start - end;
        for (int i = 1; i < len; i++) {
            if (mnn[i] != -1) {
                ans = Math.max(ans, mnn[i] - start);
                start = mxx[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}