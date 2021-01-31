package problemsolving.homework;

import java.util.*;

public class MergeTwoSortedArrays
{
    public static int[] solve(final int[] A, final int[] B) {
        int m = A.length, n = B.length;
        int[] C = new int[m+n];
        int i=0,j=0,k=0;
        while(i < m && j < n) {
            if (A[i] <= B[j]) {
                C[k++] = A[i];
                i++;
            } else {
                C[k++] = B[j];
                j++;
            }
        }
        while (i < m) {
            C[k++] = A[i];
            i++;
        }
        while (j < n) {
            C[k++] = B[j];
            j++;
        }
        return C;
    }

    public static void main(String[] args)
    {
        int[] A = {4, 7, 9};
        int[] B = {2 ,11, 19};
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
