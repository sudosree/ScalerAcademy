package problemsolving.homework;

import java.util.*;

public class ElementsRemoval1
{
    private static int solve(int[] A) {
        int cost = 0, sum = 0;
        Arrays.sort(A);
        for (int i=0;i<A.length;i++) {
            sum += A[i];
            cost += sum;
        }
        return cost;
    }

    /**
     * Check how many times a no. will contribute to the cost
     */
    private static int solve1(int[] A) {
        int cost = 0, count = 1;
        Arrays.sort(A);
        for (int i=A.length-1;i>=0;i--) {
            cost += count * A[i];
            count++;
        }
        return cost;
    }

    public static void main(String[] args)
    {
        int[] A = {4,2,1,3};
        System.out.println(solve1(A));
    }
}
