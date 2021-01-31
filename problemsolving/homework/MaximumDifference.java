package problemsolving.homework;

import java.util.*;

public class MaximumDifference
{
    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int s1 = 0, sum = 0;
        for (int i=0;i<A.length;i++) {
            sum += A[i];
        }
        for (int i=0;i<B;i++) {
            s1 += A[i];
        }
        // s2 = sum - s1, and we have to find |s2 - s1| which is equal to |sum - s1 - s1|
        // which is |sum - 2 * s1|
        int max = Math.abs(sum - 2 * s1);
        s1 = 0;
        for (int i=A.length-B;i<A.length;i++) {
            s1 += A[i];
        }
        max = Math.max(max, Math.abs(sum - 2 * s1));
        return max;
    }

    public static void main(String[] args)
    {
        int[] A = {2,6,8,10,12};
        int B = 4;
        System.out.println(solve(A,B));
    }
}
