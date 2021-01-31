package problemsolving.homework;

import java.util.*;

public class IntersectionOfSortedArrays
{
    public static int[] intersect(final int[] A, final int[] B) {
        List<Integer> list = new ArrayList<>();
        int m = A.length, n = B.length;
        int i=0,j=0;
        while (i<m && j<n) {
            if (A[i] == B[j]) {
                list.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k=0;k<list.size();k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 3, 4, 5, 6};
        int[] B = {3,3,5};
        System.out.println(Arrays.toString(intersect(A,B)));
    }
}
