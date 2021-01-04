package hashmap.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Given an array A of N integers, find the index of values that satisfy P + Q = R + S, where P,Q,R & S are integers values in the array
 *
 * Expected time complexity O(N2)
 *
 * NOTE:
 *
 * 1) Return the indices `A1 B1 C1 D1`, so that
 *   A[A1] + A[B1] = A[C1] + A[D1]
 *   A1 < B1, C1 < D1
 *   A1 < C1, B1 != D1, B1 != C1
 *
 * 2) If there are more than one solutions,
 *    then return the tuple of values which are lexicographical smallest.
 *
 * Assume we have two solutions
 * S1 : A1 B1 C1 D1 ( these are values of indices in the array )
 * S2 : A2 B2 C2 D2
 *
 * S1 is lexicographically smaller than S2 if:
 *   A1 < A2 OR
 *   A1 = A2 AND B1 < B2 OR
 *   A1 = A2 AND B1 = B2 AND C1 < C2 OR
 *   A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 *
 * If no solution is possible, return an empty list.
 *
 *
 *
 * **Problem Constraints**
 *
 * 1 <= N <= 1000
 *
 * 0 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 *
 * Single argument which is an integer array A of size N.
 *
 *
 * Output Format
 *
 * Return an array of size 4 which indexes of values P,Q,R and S.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [3, 4, 7, 1, 2, 9, 8]
 *
 * Input 2:
 *
 *  A = [2, 5, 1, 6]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [0, 2, 3, 5]
 *
 * Output 2:
 *
 *  [0, 1, 2, 3]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  A[0] + A[2] = A[3] + A[5]
 *  Note: indexes returned should be 0-based.
 *
 * Explanation 2:
 *
 *  A[0] + A[1] = A[2] + A[3]
 */
public class Equal
{
    static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private static int[] solve(int[] A) {
        int[] ans = new int[0];
        Map<Integer, Pair> map = new HashMap<>();
        // find all the possible pairs and store their sums in a hashmap
        // with their indices
        for (int c=0;c<A.length;c++) {
            for (int d=c+1;d<A.length;d++) {
                int sum = A[c]+A[d];
                if (map.containsKey(sum)) {
                    Pair pair = map.get(sum);
                    int a = pair.key;
                    int b = pair.value;
                    if (a < b && c < d && a < c && b != d && b != c) {
                        int[] curr = new int[]{a,b,c,d};
                        if (ans.length == 0) {
                            ans = curr;
                        }
                        // check if curr is lexicographically smaller than ans
                        else {
                            ans = checkLexicographically(ans, curr);
                        }
                    }
                } else {
                    map.put(sum, new Pair(c, d));
                }
            }
        }
        return ans;
    }

    private static int[] checkLexicographically(int[] num1, int[] num2) {
        if (num1[0] < num2[0] || (num1[0] == num2[0] && num1[1] < num2[1]) || (num1[0] == num2[0] && num1[1] == num2[1] && num1[2] < num2[2])
                || (num1[0] == num2[0] && num1[1] == num2[1] && num1[2] == num2[2] && num1[3] < num2[3])) {
            return num1;
        }
        return num2;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 5, 1, 6};
        int[] res = solve(A);
        for (int i=0;i<res.length;i++) {
            System.out.print(res[i] + " ");
        }
    }
}
