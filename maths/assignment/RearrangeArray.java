package maths.assignment;

import java.util.*;

public class RearrangeArray
{
    private static List<Integer> arrange(List<Integer> A) {
        int n = A.size();
        for (int i=0;i<n;i++) {
            A.set(i, A.get(i) * n);
        }
        for (int i=0;i<n;i++) {
            // to retrieve the old number
            int old = A.get(i)/n;
            int old_num = A.get(old)/n;
            A.set(i, A.get(i) + old_num);
        }
        for (int i=0;i<n;i++) {
            // to retrieve the new number
            A.set(i,A.get(i)%n);
        }
        return A;
    }

    public static void main(String[] args)
    {
        List<Integer> A = Arrays.asList(3,2,0,1);
        System.out.println(arrange(A));
    }
}
