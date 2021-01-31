package maths.homework;

/**
 * Problem Description
 *
 * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
 * Assume that no characters are repeated.
 *
 * Note: The answer might not fit in an integer, so return your answer % 1000003
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 1000
 *
 *
 * Input Format
 *
 * First argument is a string A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the rank of the given string.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = "acb"
 *
 * Input 2:
 *
 * A = "a"
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 2
 *
 * Output 2:
 *
 * 1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Given A = "acd".
 * The order permutations with letters 'a', 'c', and 'b' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank of A is 2.
 *
 * Explanation 2:
 *
 * Given A = "a".
 * Rank is clearly 1.
 */
public class SortedPermutationRank
{

    /**
     * TC = O(n^2), SC = O(n)
     */
    private static int findRank(String A) {
        char[] c = A.toCharArray();
        int[] fact = new int[c.length];
        fact[0] = 1;
        for (int i=1;i<c.length;i++) {
            fact[i] = fact[i-1] * i;
        }
        int rank = 0;
        for (int i=0;i<c.length;i++) {
            int count = 0;
            for (int j=i+1;j<c.length;j++) {
                if (c[j] < c[i]) {
                    count++;
                }
            }
            rank += count * fact[c.length - i - 1];
        }
        return rank + 1;
    }

    public static void main(String[] args)
    {
        String A = "string";
        System.out.println(findRank(A));
    }
}
