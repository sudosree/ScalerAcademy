package problemsolving.homework;

import java.util.*;

public class CommonElements1
{
    private static int[] solve(int[] A, int[] B) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<A.length;i++) {
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        for (int i=0;i<B.length;i++) {
            if (freq.containsKey(B[i]) && freq.get(B[i]) > 0) {
                list.add(B[i]);
                freq.put(B[i], freq.get(B[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i=0;i< list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 1, 4, 10};
        int[] B = {3, 6, 2, 10, 10};
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
