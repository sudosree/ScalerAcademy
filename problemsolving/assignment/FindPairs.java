package problemsolving.assignment;

import java.util.*;

public class FindPairs
{
    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            map.put(A[i],i);
        }
        int count = 0;
        for (int i=0;i<A.length-1;i++) {
            for (int j=i+1;j<A.length;j++) {
                int sum = A[i] + A[j];
                if (map.containsKey(sum)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] A = {3, 4, 2, 6 ,7};
        System.out.println(solve(A));
    }
}
