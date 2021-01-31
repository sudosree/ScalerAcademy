package problemsolving.assignment;

import java.util.*;

/**
 * You are given a read only array of n integers from 1 to n.
 *
 * Each integer appears exactly once except A which appears twice and B which is missing.
 *
 * Return A and B.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Note that in your output A should precede B.
 *
 * Example:
 *
 * Input:[3 1 2 5 3]
 *
 * Output:[3, 4]
 *
 * A = 3, B = 4
 */
public class RepeatAndMissingNumberArray
{
    /**
     * TC = O(n), SC = O(1)
     */
    private static int[] repeatedNumber(int[] A) {
        int n = A.length;
        long sum = ((long)n * ((long)n+1)/2);
        long sqrSum = ((long)n * ((long)n+1)/2) * (2 * (long)n + 1)/3;
        for (int i=0;i<A.length;i++) {
            sum -= A[i];
            sqrSum -= (long) A[i] * A[i];
        }
        // where m - r = sum, m^2 - r^2 = sqrSum
        // m + r = sqrSum/sum, m = (sqrSum/sum + sum)/2
        // r = m - sum
        long missingNo = (sqrSum/sum + sum)/2;
        long repeatingNo = missingNo - sum;
        int[] res = new int[2];
        res[0] = (int)repeatingNo;
        res[1] = (int)missingNo;
        return res;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    private static int[] repeatedNumber1(int[] A) {
        Map<Integer, Integer> freq = new HashMap<>();
        int repeatingNo = -1;
        for (int i=0;i<A.length;i++) {
            if (freq.containsKey(A[i])) {
                if (freq.get(A[i]) == 1) {
                    repeatingNo = A[i];
                }
            } else {
                freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
            }
        }
        int missingNo = -1;
        for (int i=1;i<=A.length;i++) {
            if (!freq.containsKey(i)) {
                missingNo = i;
                break;
            }
        }
        return new int[]{repeatingNo, missingNo};
    }

    public static void main(String[] args)
    {
        int[] A = {3,1,2,3,5};
        System.out.println(Arrays.toString(repeatedNumber1(A)));
    }
}
