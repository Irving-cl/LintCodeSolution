package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class FindMinimumInRotatedSortedArray2 {

    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (num[mid] > num[hi]) {
                lo = mid + 1;
            } else if (num[mid] < num[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return num[lo];
    }

    public static void main(String[] args) {

    }
}
