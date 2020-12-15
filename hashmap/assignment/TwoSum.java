package hashmap.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
 *
 * If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 *
 * Input: [2, 7, 11, 15], target=9
 * Output: index1 = 1, index2 = 2
 */
public class TwoSum
{
    private static int[] twoSum(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            // if an element A[i] is not present in the map and also if its complement is not present,
            // then add the element A[i] into the map
            // if an element A[i] is already present in the map then do not add it again, instead check if its complement
            // is present in the map or not.
            // if the complement is present then return the index of A[i] and its complement, else continue with the next element
            if (!map.containsKey(A[i]) && !map.containsKey(B-A[i])) {
                map.put(A[i], i+1);
            } else if (map.containsKey(B-A[i])){
                return new int[]{map.get(B-A[i]), i+1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args)
    {
        int[] A = {-10,-10,-10};
        int B = -5;
        int[] ans = twoSum(A, B);
        for (int i=0;i<ans.length;i++) {
            System.out.println(ans[i]);
        }
    }
}
