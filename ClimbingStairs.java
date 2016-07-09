package com.algorithm;

public class ClimbingStairs {

    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        int a = 0, b = 1, c = 1;
        for ( ; n > 0; n--) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }
}
