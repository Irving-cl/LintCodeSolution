package com.algorithm;

public class CosineSimilarity {

    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public static double cosineSimilarity(int[] A, int[] B) {
        int divisor = 0;
        int normA = 0;
        int normB = 0;
        for (int i = 0; i < A.length; i++) {
            divisor += A[i] * B[i];
            normA += A[i] * A[i];
            normB += B[i] * B[i];
        }
        if (normA == 0 || normB == 0) {
            return 2.0000f;
        }
        return (double) divisor / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3 };
        int[] B = { 2, 3, 4 };
        System.out.println(cosineSimilarity(A, B));
        int[] C = { 0 };
        int[] D = { 0 };
        System.out.println(cosineSimilarity(C, D));
    }
}
