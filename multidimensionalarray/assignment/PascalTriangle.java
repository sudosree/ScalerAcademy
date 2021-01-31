package multidimensionalarray.assignment;

import java.util.*;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Given numRows = 5,
 *
 * Return
 *
 * [
 *      [1],
 *      [1,1],
 *      [1,2,1],
 *      [1,3,3,1],
 *      [1,4,6,4,1]
 * ]
 */
public class PascalTriangle
{
    private static int[][] solve(int A) {
        int[][] matrix = new int[A][];
        for (int i=0;i<A;i++) {
            matrix[i] = new int[i+1];
            for (int j=0;j<=i;j++) {
                // first and last element will always be 1
                if (j == 0 || j == i) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
                }
            }
        }
        return matrix;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        generateRows(numRows, ans);
        return ans;
    }

    private static void generateRows(int numRows, List<List<Integer>> ans) {
        if (numRows == 1) {
            ans.add(Arrays.asList(1));
            return;
        }
        // if numRows > 1, generate the previous row
        generateRows(numRows-1, ans);
        List<Integer> prev_row = ans.get(numRows-2);
        List<Integer> curr_row = new ArrayList<>();
        // first element in a row is 1
        curr_row.add(1);
        for (int i=1;i<prev_row.size();i++) {
            curr_row.add(prev_row.get(i) + prev_row.get(i-1));
        }
        // last element in a row is 1
        curr_row.add(1);
        ans.add(curr_row);
    }

    /**
     * TC = o(numRows^2)
     */
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }

        // for the 1st row, there is only 1
        List<Integer> curr_row = new ArrayList<>();
        curr_row.add(1);
        triangle.add(curr_row);

        // for each row in a pascal triangle
        for (int i=1; i<numRows; i++) {
            curr_row = new ArrayList<>();
            // first element in every row is 1
            curr_row.add(1);
            List<Integer> prev_row = triangle.get(i-1);
            for (int j=1; j<prev_row.size(); j++) {
                //C[i,j] = C[i-1,j] + C[i-1,j-1]
                curr_row.add(prev_row.get(j) + prev_row.get(j-1));
            }
            // last element in every row is 1
            curr_row.add(1);
            triangle.add(curr_row);
        }
        return triangle;
    }

    public static void main(String[] args)
    {
        int A = 5;
        int[][] res = solve(A);
        for (int i=0;i<res.length;i++) {
            for (int j=0;j<res[0].length;j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
