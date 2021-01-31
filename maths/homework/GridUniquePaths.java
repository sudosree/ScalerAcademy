package maths.homework;

import java.util.*;

/**
 * A robot is located at the top-left corner of an A x B grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Problem Constraints
 *
 * A and B will be such that the resulting answer fits in a 32 bit signed integer.
 *
 *
 * Input Format
 *
 * First argument of input will be single integer A.
 * Second argument of input will be single integer B.
 *
 *
 * Output Format
 *
 * Return a single integer denoting the number of unique paths.
 *
 *
 * Example Input
 *
 *  A = 2, B = 2
 *
 *
 *
 * Example Output
 *
 *  2
 *
 *
 *
 * Example Explanation
 *
 *  2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 *               OR  : (0, 0) -> (1, 0) -> (1, 1)
 */
public class GridUniquePaths
{
    private static int count = 0;

    private static int uniquePaths(int A, int B) {
        backtrack(A,B,0,0);
        return count;
    }

    private static void backtrack(int A, int B, int i, int j) {
        if (i == A || j == B) {
            return;
        }
        if (i == A-1 && j == B-1) {
            count++;
            return;
        }
        // move right
        backtrack(A,B,i,j+1);
        // move down
        backtrack(A,B,i+1,j);
    }

    private static int uniquePaths1(int A, int B) {
        // where n is the total no. of steps needed to reach the destination
        // In total (A-1) steps are required to move down and (B-1) steps are required to move right
        // so total there are (A-1) Ds and (B-1) Rs where D represent a down step and R represent a right step
        int n = A + B - 2;
        int r = B-1;
        long count = 1;
        for (int i=1;i<=r;i++) {
            count *= (n - i + 1);
            count /= i;
        }
        return (int)count;
    }

    private static int uniquePaths2(int A, int B) {
        // where n is the total no. of steps needed to reach the destination
        // In total (A-1) steps are required to move down and (B-1) steps are required to move right
        // so total there are (A-1) Ds and (B-1) Rs where D represent a down step and R represent a right step
        int n = A + B - 2;
        long count = 1;
        for (int i=B,j=1;i<=n;i++,j++) {
            count *= i;
            count /= j;
        }
        return (int)count;
    }

    private static int uniquePaths3(int A, int B) {
        // where n is the total no. of steps needed to reach the destination
        // In total (A-1) steps are required to move down and (B-1) steps are required to move right
        // so total there are (A-1) Ds and (B-1) Rs where D represent a down step and R represent a right step
        int n = A + B - 2;
        int r = B - 1;
        if (A - 1 < B - 1) {
            r = A - 1;
        }
        int t = Math.max(A,B);
        long count = 1;
        // one approach
        /*for (int i=t,j=1;i<=n;i++,j++) {
            count *= i;
            count /= j;
        }*/
        // 2nd approach
        for (int i=1,j=t;i<=r;i++,j++) {
            count *= j;
            count /= i;
        }
        return (int)count;
    }

    private static int uniquePaths4(int A, int B) {
        // where n is the total no. of steps needed to reach the destination
        // In total (A-1) steps are required to move down and (B-1) steps are required to move right
        // so total there are (A-1) Ds and (B-1) Rs where D represent a down step and R represent a right step
        int n = A + B - 2;
        int r = B - 1;
        if (A - 1 < B - 1) {
            r = A - 1;
        }
        long count = 1;
        for (int i=1,j=n;i<=r;i++,j--) {
            count *= j;
            count /= i;
        }
        return (int)count;
    }

    private static int uniquePaths5(int m, int n) {
        int[][] dp = new int[m][n];
        // for the first row fill all the cells with 1 as there is only one path to
        // reach the cell in the first row i.e. moving right -> right -> right -> ..... -> right
        for (int i=0;i<n;i++) {
            dp[0][i] = 1;
        }
        // for the first column fill all the cells with 1 as there is only one path to reach the cell
        // in the first column i.e. moving down -> down -> down -> down -> ..... -> down
        for (int i=0;i<m;i++) {
            dp[i][0] = 1;
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                // where dp[i-1][j] denotes the above cell
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args)
    {
        int A = 3, B = 3;
        System.out.println(uniquePaths4(A, B));
    }
}
