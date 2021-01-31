package multidimensionalarray.practice;

import java.util.*;

public class SortRowCol
{
    private static int[][] solve(int[][] A) {
        int n = A.length;
        //sort the rows
        for (int i=0;i<n;i++) {
            Arrays.sort(A[i]);
        }
        // get the transpose
        A = transpose(A);
        //sort the rows
        for (int i=0;i<n;i++) {
            Arrays.sort(A[i]);
        }
        // get the transpose
        A = transpose(A);
        return A;
    }

    private static int[][] transpose(int[][] A) {
        int n = A.length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                A[j][i] = A[i][j];
            }
        }
        return A;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {4,1,3},
                {9,6,8},
                {5,2,7}
        };
        System.out.println(Arrays.deepToString(solve(A)));
    }
}
