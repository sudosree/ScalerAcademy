package problemsolving.assignment;

import java.util.*;

public class ArithmeticProgressionNew
{
    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++) {
            map.put(A[i],i);
            if (A[i] < min) {
                secondMin = min;
                min = A[i];
            } else if (A[i] < secondMin) {
                secondMin = A[i];
            }
        }
        int d = secondMin - min;
        int i = 1;
        while (i < A.length-1) {
            if (map.containsKey(secondMin + i * d)) {
                i++;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 4, 1};
        System.out.println(solve(A));
    }
}
