package problemsolving.assignment;

import java.util.*;

public class MinimizeDifferencePuzzle
{

    /**
     * TC = O(nlogn)
     */
    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<=A.length-B;i++) {
            // diff = max - min
            int diff = A[i+B-1] - A[i];
            ans = Math.min(ans, diff);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {10, 12, 10, 7, 5, 22};
        int B = 4;
        System.out.println(solve(A,B));
    }
}
