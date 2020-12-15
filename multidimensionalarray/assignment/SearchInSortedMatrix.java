package multidimensionalarray.assignment;

/**
 * Problem Description
 * Given a matrix of integers A of size N x M and an integer B.
 *
 * In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return (i * 1009 + j)
 * If B is not present return -1.
 *
 * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * -100000 <= B <= 100000
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 *
 *
 * Output Format
 * Return the position of B and if it is not present in A return -1 instead.
 *
 *
 * Example Input
 * A = [ [1, 2, 3]
 *           [4, 5, 6]
 *           [7, 8, 9] ]
 * B = 2
 *
 *
 * Example Output
 * 1011
 *
 *
 * Example Explanation
 * A[1][2]= 2
 * 1*1009 + 2 =1011
 */
public class SearchInSortedMatrix
{
    private static int solve(int[][] A, int B) {
        int row = A.length, col = A[0].length;
        int i=0, j = col-1;

        while (i < row && j >= 0) {
            int num = A[i][j];
            if (num == B) {
                return (i + 1) * 1009 + (j + 1);
            }
            // move down
            if (num < B) {
                i++;
            }
            // move left
            else {
                j--;
            }
        }
        return -1;
    }

    private static int solve1(int[][] A, int B) {
        int row = A.length, col = A[0].length;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (A[i][j] == B) {
                    return (i+1)*1009+(j+1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {5,10,15,20},
                {6,12,20,23},
                {7,13,24,26},
                {10,15,23,27}
        };
        int B = 20;
        System.out.println(solve(A,B));
    }
}
