package problemsolving.assignment;

import java.util.*;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example :
 *
 * Input : [2, 1, 2]
 * Return  : 2 which occurs 2 times which is greater than 3/2.
 */
public class MajorityElement
{

    /**
     * TC = O(n), SC = O(n)
     */
    private static int majorityElement(int[] A) {
        int half = A.length/2;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            if (!freq.containsKey(A[i])) {
                freq.put(A[i], 1);
            } else {
                freq.put(A[i], freq.get(A[i]) + 1);
            }
            if (freq.get(A[i]) > half) {
                return A[i];
            }
        }
        return -1;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    private static int majorityElement1(int[] A) {
        int majority_element = -1, count = 0;
        for (int i=0;i<A.length;i++) {
            if (count == 0) {
                majority_element = A[i];
                count = 1;
            } else if (A[i] == majority_element) {
                count++;
            } else {
                count--;
            }
        }
        return majority_element;
    }

    private static int majorityElement2(int[] A) {
        int half = A.length/2;
        for (int i=0;i<A.length;i++) {
            int count = 0;
            for (int j=i;j<A.length;j++) {
                if (A[i] == A[j]) {
                    count++;
                }
            }
            if (count > half) {
                return A[i];
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] A = {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(A));
    }
}
