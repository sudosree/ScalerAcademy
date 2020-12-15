package multidimensionalarray.assignment;

/**
 * Problem Description
 *
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 1000
 *
 *
 * Input Format
 *
 * First and only argument is integer A
 *
 *
 *
 * Output Format
 *
 * Return a 2-D matrix which consists of the elements in spiral order.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * 1
 *
 * Input 2:
 *
 * 2
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [ [1] ]
 *
 * Output 2:
 *
 * [ [1, 2], [4, 3] ]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 * Only 1 is to be arranged.
 *
 * Explanation 2:
 *
 * 1 --> 2
 *       |
 *       |
 * 4<--- 3
 */
public class SpiralMatrixII
{
    private static int[][] generateMatrix(int A) {
        int[][] matrix = new int[A][A];
        int top = 0, bottom = A-1, left = 0, right = A-1;
        int num = 0;
        while (top <= bottom && left <= right) {

            // move from left to right
            for (int i=left; i<=right; i++) {
                matrix[top][i] = ++num;
            }
            // move top boundary
            top++;

            // move from top to down
            for (int i=top; i<=bottom; i++) {
                matrix[i][right] = ++num;
            }
            // move right boundary
            right--;

            // move from right to left
            for (int i=right; i>=left; i--) {
                matrix[bottom][i] = ++num;
            }
            // move bottom boundary
            bottom--;

            // move from bottom to top
            for (int i=bottom; i>=top; i--) {
                matrix[i][left] = ++num;
            }
            // move left boundary
            left++;
        }
        return matrix;
    }

    public static void main(String[] args)
    {
        int A = 5;
        int[][] n = generateMatrix(A);
        for (int i=0;i<n.length;i++) {
            for (int j=0;j<n[0].length;j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }
}
