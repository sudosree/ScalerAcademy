package multidimensionalarray.assignment;

/**
 * Problem Description
 *
 * Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.
 *
 * NOTE:
 *
 *     If two rows have the maximum number of 1 then return the row which has a lower index.
 *     Rows are numbered from top to bottom and columns are numbered from left to right.
 *     Assume 0-based indexing.
 *     Assume each row to be sorted by values.
 *     Expected time complexity is O(rows).
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 1000
 *
 * 0 <= A[i] <= 1
 *
 *
 *
 * Input Format
 *
 * The only argument given is the integer matrix A.
 *
 *
 * Output Format
 *
 * Return the row with the maximum number of 1.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [   [0, 1, 1]
 *          [0, 0, 1]
 *          [0, 1, 1]   ]
 *
 * Input 2:
 *
 *  A = [   [0, 0, 0, 0]
 *          [0, 1, 1, 1]    ]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  0
 *
 * Output 2:
 *
 *  1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Row 0 has maximum number of 1s.
 *
 * Explanation 2:
 *
 *  Row 1 has maximum number of 1s.
 */
public class RowWithMaxOnes
{
    private static int solve(int[][] A) {
        int row = A.length, col = A[0].length;
        int rowIndex = -1, colIndex = -1;

        for (int i=0; i<row; i++) {
            // if no leftmost 1 found in a row then find it
            if (rowIndex == -1) {
                for (int j=0;j<col;j++) {
                    // find first leftmost 1 in a row
                    if (A[i][j] == 1) {
                        rowIndex = i;
                        colIndex = j;
                        break;
                    }
                }
            }
            // if the element is 1 in the next row at the same col position
            else if (A[i][colIndex] == 1) {
                // good find
                // move left, there can be 1 on its left side
                int j = colIndex-1;
                while (j >= 0 && A[i][j] != 0) {
                    rowIndex = i;
                    colIndex = j;
                    j--;
                }
            }
        }
        return rowIndex;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {0,0,0,1},
                {0,0,0,1},
                {0,0,1,1},
                {0,1,1,1},
                {1,1,1,1}
        };
        System.out.println(solve(A));
    }
}
