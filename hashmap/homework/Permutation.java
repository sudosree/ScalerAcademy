package hashmap.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 *
 * You are given two strings A and B of size N and M respectively.
 *
 * You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N < M <= 105
 *
 *
 * Input Format
 *
 * Given two argument, A and B of type String.
 *
 *
 * Output Format
 *
 * Return a single Integer, i.e number of permutations of A present in B as a substring.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "abc"
 *  B = "abcbacabc"
 *
 * Input 2:
 *
 *  A = "aca"
 *  B = "acaa"
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  5
 *
 * Output 2:
 *
 *  2
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Permutations of A that are present in B as substring are:
 *     1. abc
 *     2. cba
 *     3. bac
 *     4. cab
 *     5. abc
 *     So ans is 5.
 *
 * Explanation 2:
 *
 *  Permutations of A that are present in B as substring are:
 *     1. aca
 *     2. caa
 */
public class Permutation
{
    private static int solve(String A, String B) {
        int count = 0;

        // calculate the frequency of each character of A
        Map<Integer, Integer> freqA = new HashMap<>();
        for (int i=0;i<A.length();i++) {
            int c = A.charAt(i) - 'a';
            freqA.put(c, freqA.getOrDefault(c,0)+1);
        }

        // calculate the frequency of each character for the first window in B
        Map<Integer, Integer> freqB = new HashMap<>();
        for (int i=0;i<A.length();i++) {
            int c = B.charAt(i) - 'a';
            freqB.put(c, freqB.getOrDefault(c,0)+1);
        }

        if (compareFrequencyMap(freqA, freqB)) {
            count++;
        }

        // calculate the frequency of each character for the remaining windows in B
        for (int i=A.length(),j=0;i<B.length();i++,j++) {
            int c1 = B.charAt(j) - 'a';
            // delete the first character in a window
            freqB.put(c1, freqB.get(c1)-1);
            // add the last character in a new window
            int c2 = B.charAt(i) - 'a';
            freqB.put(c2, freqB.getOrDefault(c2,0)+1);
            if (compareFrequencyMap(freqA, freqB)) {
                count++;
            }
        }

        return count;
    }

    private static boolean compareFrequencyMap(Map<Integer, Integer> freqA, Map<Integer, Integer> freqB) {
        for (int index : freqA.keySet()) {
            if (!freqB.containsKey(index) || !freqA.get(index).equals(freqB.get(index))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        String A = "aca", B = "acaa";
        System.out.println(solve(A,B));
    }
}
