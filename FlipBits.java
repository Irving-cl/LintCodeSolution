package com.algorithm;

public class FlipBits {

    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int xor = a ^ b;
        int res = 0;
        while (xor != 0) {
            xor = xor & (xor - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(bitSwapRequired(31, 14));
    }
}
