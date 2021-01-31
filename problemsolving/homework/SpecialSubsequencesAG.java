package problemsolving.homework;

import java.util.*;

/**
 * Problem Description
 *
 * You have given a string A having Uppercase English letters.
 *
 * You have to find that how many times subsequence "AG" is there in the given string.
 *
 * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length(A) <= 105
 *
 *
 * Input Format
 *
 * First and only argument is a string A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the answer.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "ABCGAG"
 *
 * Input 2:
 *
 *  A = "GAB"
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  3
 *
 * Output 2:
 *
 *  0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Subsequence "AG" is 3 times in given string
 *
 * Explanation 2:
 *
 *  There is no subsequence "AG" in the given string.
 */
public class SpecialSubsequencesAG
{

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int solve(String A) {
        int mod = 1000000007;
        char[] ch = A.toCharArray();
        int count = 0;
        for (int i=0;i<ch.length-1;i++) {
            for (int j=i+1;j<ch.length;j++) {
                if (ch[i] != 'A') {
                    break;
                }
                if (ch[j] == 'G') {
                    count = (count + 1) % mod;
                }
            }
        }
        return count % mod;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    private static int solve1(String A) {
        int mod = 1000000007;
        // store the count of A to the left of G
        int count_a = 0;
        int count = 0;
        char[] ch = A.toCharArray();
        for (int i=0;i<ch.length;i++) {
            if (ch[i] == 'A') {
                count_a = (count_a + 1) % mod;
            }
            if (ch[i] == 'G') {
                count = (count + count_a) % mod;
            }
        }
        return count % mod;
    }

    private static int solve2(String A) {
        int mod = 1000000007;
        // store the count of G to the right of A
        int count_g = 0;
        int count = 0;
        char[] ch = A.toCharArray();
        for (int i=ch.length-1;i>=0;i--) {
            if (ch[i] == 'G') {
                count_g = (count_g + 1) % mod;
            }
            if (ch[i] == 'A') {
                count = (count + count_g) % mod;
            }
        }
        return count % mod;
    }

    public static void main(String[] args)
    {
        String A = "ABCGAG";
        System.out.println(solve2(A));
    }
}
