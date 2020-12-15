package problemsolving;

import java.util.Scanner;

/**
 * Problem Description
 *
 * Print a Pattern According to The Given Value of A.
 *
 * Example: For A = 3 pattern looks like:
 *
 * 1
 *
 * 1 2
 *
 * 1 2 3
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1000
 *
 *
 * Input Format
 *
 * First and only argument is an integer denoting A.
 *
 *
 * Output Format
 *
 * Return a two-dimensional array where each row in the returned array represents a row in the pattern.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 3
 *
 * Input 2:
 *
 *  A = 4
 *
 *
 *
 * Example Output
 *
 * Output :1
 *
 *  [
 *    [1]
 *    [1, 2]
 *    [1, 2, 3]
 *  ]
 *
 * Output 2:
 *
 *  [
 *    [1]
 *    [1, 2]
 *    [1, 2, 3]
 *    [1, 2, 3, 4]
 *  ]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 2:
 *
 *
 *  For A = 4 pattern looks like:
 *                              1
 *                              1 2
 *                              1 2 3
 *                              1 2 3 4
 *  So we will return it as two-dimensional array.
 */
public class PatternPrinting
{
    private static int[][] solve(int A) {
        int[][] res = new int[A][];
        for (int i=1;i<=A;i++) {
            res[i-1] = new int[i];
            for (int j=1;j<=i;j++) {
                res[i-1][j-1] = j;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int[][] arr = solve(A);
        for (int i=0;i< arr.length;i++) {
            for (int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
