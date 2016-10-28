package com.algorithm;

import java.util.ArrayList;

public class ReversePairs {
    private long ans;

    public ArrayList<Integer> divide(int[] A, int l, int r) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (l == r) {
            arrayList.add(A[l]);
            return arrayList;
        }
        int mid = (l + r) >> 1;
        ArrayList<Integer> left = divide(A, l, mid);
        ArrayList<Integer> right = divide(A, mid + 1, r);
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                arrayList.add(left.get(i));
                i++;
            } else {
                arrayList.add(right.get(j));
                ans += (left.size() - i);
                j++;
            }
        }
        if (i == left.size()) {
            for ( ; j < right.size(); j++) {
                arrayList.add(right.get(j));
            }
        } else {
            for ( ; i < left.size(); i++) {
                arrayList.add(left.get(i));
            }
        }
        return arrayList;
    }

    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        divide(A, 0, A.length - 1);
        return ans;
    }

    public static void main(String[] args) {

    }
}
