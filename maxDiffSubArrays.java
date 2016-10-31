package com.algorithm;

public class maxDiffSubArrays {

    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int sum1 = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum2 = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum1 += nums[i];
            maxSum = Math.max(sum1, maxSum);
            if (sum1 < 0) {
                sum1 = 0;
            }
            a[i] = maxSum;
            sum2 += nums[n - 1 - i];
            minSum = Math.min(sum2, minSum);
            if (sum2 > 0) {
                sum2 = 0;
            }
            b[n - 1 - i] = minSum;
        }
        int res = -1;
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, Math.abs(a[i] - b[i + 1]));
        }
        sum1 = 0;
        maxSum = Integer.MIN_VALUE;
        sum2 = 0;
        minSum = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            sum1 += nums[i];
            maxSum = Math.max(sum1, maxSum);
            if (sum1 < 0) {
                sum1 = 0;
            }
            a[i] = maxSum;
            sum2 += nums[n - 1 - i];
            minSum = Math.min(sum2, minSum);
            if (sum2 > 0) {
                sum2 = 0;
            }
            b[n - 1 - i] = minSum;
        }
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, Math.abs(a[i + 1] - b[i]));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
