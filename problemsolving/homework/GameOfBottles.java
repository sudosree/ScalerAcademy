package problemsolving.homework;

import java.util.*;

public class GameOfBottles
{
    private static int solve(int[] A) {
        if (A.length == 1) {
            return 1;
        }
        Arrays.sort(A);
        int i=0,j=1;
        while (i < A.length && j < A.length) {
            if (A[i] < A[j]) {
                i++;
            }
            j++;
        }
        return A.length - i;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3};
        System.out.println(solve(A));
    }
}
