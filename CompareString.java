package com.algorithm;

public class CompareString {

    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public static boolean compareStrings(String A, String B) {
        int[] mapping = new int[26];
        for (int i = 0; i < A.length(); i++) {
            mapping[A.charAt(i) - 'A']++;
        }
        for (int i = 0; i < B.length(); i++) {
            if (--mapping[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(compareStrings("ABCD", "ACD"));
        System.out.println(compareStrings("ABCD", "AABC"));
    }
}
