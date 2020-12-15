package multidimensionalarray.practice;

public class SpiralMatrix
{
    private static void print(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int top = 0, bottom = rows-1, left = 0, right = cols-1;

        while (left <= right && top <= bottom) {
            // move from left to right
            for (int i=left; i<=right; i++) {
                System.out.print(A[top][i] + " ");
            }
            // move the top boundary
            top++;
            System.out.println();
            // move from top to bottom
            for (int i=top; i<=bottom; i++) {
                System.out.print(A[i][right] + " ");
            }
            // move the right boundary
            right--;
            System.out.println();
            if (left < right && top < bottom) {
                // move from right to left
                for (int i=right; i>=left; i--) {
                    System.out.print(A[bottom][i] + " ");
                }
                // move the bottom boundary
                bottom--;
                System.out.println();
                // move from bottom to top
                for (int i=bottom; i>=top; i--) {
                    System.out.print(A[i][left] + " ");
                }
                // move the left boundary
                left++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        print(A);
    }
}
