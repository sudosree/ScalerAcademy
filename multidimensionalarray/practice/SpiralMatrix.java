package multidimensionalarray.practice;

import java.util.*;

public class SpiralMatrix
{
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m-1, left = 0, right = n-1;
        while (left <= right && top <= bottom) {
            // print the top
            for (int i=left;i<=right;i++) {
                res.add(matrix[top][i]);
            }
            // move the top
            top++;
            // print the right
            for (int i=top;i<=bottom;i++) {
                res.add(matrix[i][right]);
            }
            // boundary conditions
            if (top > bottom) {
                break;
            }
            // move the right
            right--;
            // print the bottom
            for (int i=right;i>=left;i--) {
                res.add(matrix[bottom][i]);
            }
            // boundary conditions
            if (right < left) {
                break;
            }
            // move the bottom
            bottom--;
            // print the left
            for (int i=bottom;i>=top;i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    public static int[] spiralOrder1(final int[][] A) {
        int m = A.length, n = A[0].length;
        int[] res = new int[m*n];
        int top = 0, bottom = m-1, left = 0, right = n-1;
        int k=0;
        while (left <= right && top <= bottom) {
            // print the top
            for (int i=left;i<=right;i++) {
                res[k++] = A[top][i];
            }
            // move the top
            top++;
            // print the right
            for (int i=top;i<=bottom;i++) {
                res[k++] = A[i][right];
            }
            // boundary conditions
            if (top > bottom) {
                break;
            }
            // move the right
            right--;
            // print the bottom
            for (int i=right;i>=left;i--) {
                res[k++] = A[bottom][i];
            }
            // boundary conditions
            if (right < left) {
                break;
            }
            // move the bottom
            bottom--;
            // print the left
            for (int i=bottom;i>=top;i--) {
                res[k++] = A[i][left];
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        System.out.println(Arrays.toString(spiralOrder1(A)));
    }
}
