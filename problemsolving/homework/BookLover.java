package problemsolving.homework;

import java.util.*;

public class BookLover
{
    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i=0;i<A.length;i++) {
            count++;
            map.put(A[i], count);
        }
        int min = Integer.MAX_VALUE;
        int book = -1;
        for (int num : map.keySet()) {
            if (map.get(num) < min) {
                min = map.get(num);
                book = num;
            }
        }
        return book;
    }

    public static void main(String[] args)
    {
        int[] A = {7, 8, 4, 2, 7};
        System.out.println(solve(A));
    }
}
