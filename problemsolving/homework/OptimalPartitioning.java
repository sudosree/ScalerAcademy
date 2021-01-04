package problemsolving.homework;

import java.util.*;

public class OptimalPartitioning
{
    private static int solve(int[] A) {
        Arrays.sort(A);
        int diff = Integer.MAX_VALUE;
        for (int i=0;i<A.length-1;i++) {
            int max = A[i];
            int min = A[i+1];
            diff = Math.min(diff, Math.abs(max-min));
        }
        return diff;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 1, 3, 2, 4, 3};
        System.out.println(solve(A));
    }
}
