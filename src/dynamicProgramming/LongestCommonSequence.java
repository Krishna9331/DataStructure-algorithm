package dynamicProgramming;

/**
 * Created by mishrk3 on 7/28/2016.
 * <p>
 * <p>
 * /**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * <p>
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences
 * between two files), and has applications in bioinformatics.
 * <p>
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSequence {

    /**
     * Let's consider the sequence is X[0.. m-1]  and Y[0..n-1] and L(X[0.. m-1], Y[0..n-1]) is max common sequence.
     * <p>
     * So we have two condition:
     * if last character of both sequence match
     * L(X[0.. m-1], Y[0..n-1]) = 1 + L(X[0.. m-2], Y[0..n-2])
     * else
     * L(X[0.. m-1], Y[0..n-1]) = max(L(X[0.. m-2], Y[0..n-1]), L(X[0.. m-1], Y[0..n-2]))
     * <p>
     * The code is order of O(mn)
     */

    int lcs(char[] x, char[] y, int m, int n) {
        int[][] lcs = new int[m + 1][n + 1];
        int i, j = 0;

        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSequence lcs = new LongestCommonSequence();
        char[] one = {'A', 'G', 'G', 'T', 'A', 'B'};
        char[] two = {'G', 'X', 'T', 'X', 'A', 'Y', 'B'};
        System.out.println(lcs.lcs(one, two, 6, 7));
    }
}
