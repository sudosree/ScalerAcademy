package arrays.homework;

/**
 * Given an array of integers A and multiple values in B which represents the indices of the array A around which left rotation of the array A needs to be performed.
 *
 * Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the i'th value in B.
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 *
 * Output Format
 *
 * Return the resultant matrix.
 *
 * Constraints
 *
 * 1 <= length of both arrays <= 2000
 * -10^9 <= A[i] <= 10^9
 * 0 <= B[i] <= 2000
 *
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 *     B = [2, 3]
 * Output 1:
 *     [ [3, 4, 5, 1, 2]
 *       [4, 5, 1, 2, 3] ]
 *
 * Input 2:
 *     A = [5, 17, 100, 11]
 *     B = [1]
 * Output 2:
 *     [ [17, 100, 11, 5] ]
 */
public class MultipleLeftRotations
{
    private static int[][] solve(int[] A, int[] B) {
        int row = B.length, col = A.length;
        int[][] ans = new int[row][col];
        for (int i=0;i<row;i++) {
            // index around which rotation will occur
            int index = B[i];
            for (int j=0;j<col;j++) {
                ans[i][j] = A[(index+j)%col];
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {5, 17, 100, 11};
        int[] B = {1};
        int[][] ans = solve(A,B);
        for (int i=0;i<ans.length;i++) {
            for (int j=0;j<ans[0].length;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
