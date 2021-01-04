package sorting.assignment;

import java.util.*;

/**
 * Given an integer array, find if an integer p exists in the array such that the number of integers
 * greater than p in the array equals to p If such an integer is found return 1 else return -1.
 */
public class NobleInteger
{
    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    private static int solve(int[] A) {
        Arrays.sort(A);
        for (int i=0;i<A.length;i++) {
            // check if there are A[i] no. of elements present after A[i] and also
            // if the next element is not equal to the current element
            if (A[i] == (A.length - i - 1) && (i+1 < A.length && A[i] != A[i+1])) {
                return 1;
            }
            int j = i, k = j+1;
            // find the max index of the same element
            while (j < A.length && k < A.length && A[j] == A[k]) {
                j++;
                k = j+1;
            }
            // then check if there are A[j] no. of elements present after A[j]
            if (j < A.length && A[j] == (A.length - j - 1)) {
                return 1;
            }
        }
        return -1;
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    private static int solve1(int[] A) {
       for (int i=0;i<A.length;i++) {
           int count = 0;
           for (int j=0;j<A.length;j++) {
               if (A[j] > A[i]) {
                   count++;
               }
           }
           if (count == A[i]) {
               return 1;
           }
       }
       return -1;
    }

    public static void main(String[] args)
    {
        int[] A = {3,3,4,4,4,7,10};
        System.out.println(solve(A));
    }
}
