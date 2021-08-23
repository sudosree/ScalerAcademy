package problemsolving.homework;

import java.util.*;

/**
 * Problem Description
 *
 * Given an unsorted integer array A of size N. Find the first missing positive integer.
 *
 * Note: Your algorithm should run in O(n) time and use constant space.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 1000000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the first missing positive integer.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * [1, 2, 0]
 *
 * Input 2:
 *
 * [3, 4, -1, 1]
 *
 * Input 3:
 *
 * [-8, -7, -6]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 3
 *
 * Output 2:
 *
 * 2
 *
 * Output 3:
 *
 * 1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * A = [1, 2, 0]
 * First positive integer missing from the array is 3.
 */
public class FirstMissingInteger
{

    /**
     * TC = O(nlogn), SC = O(1)
     */
    private static int solve(int[] A) {
        Arrays.sort(A);
        // find the index of the first positive no.
        int pos = -1;
        for (int i=0;i<A.length;i++) {
            if (A[i] > 0) {
                pos = i;
                break;
            }
        }
        // if the first positive no. is 1
        if (pos != -1 && A[pos] == 1) {
            for (int i=pos+1;i<A.length;i++) {
                if (A[i] - A[i-1] > 1) {
                    return A[i-1] + 1;
                }
            }
            return A[A.length-1] + 1;
        }
        return 1;
    }

    /**
     * TC = O(nlogn), SC = O(1)
     */
    public int firstMissingPositive(int[] A) {
        // sort the array
        Arrays.sort(A);
        int pos = -1;
        for (int i=0;i<A.length;i++) {
            if (A[i] > 0) {
                pos = i;
                break;
            }
        }
        // if the first positive integer found is not 1 then 1 will be the answer or if there are no positive integers in the array
        if (pos == -1 || A[pos] != 1) {
            return 1;
        }
        // if the first positive integer is 1 then check if the difference between the consecutive elements are 1 or > 1
        // if the difference is > 1 then the answer will be the previous element + 1
        for (int i=pos+1;i<A.length;i++) {
            if (A[i] - A[i-1] > 1 || A[i] - A[i-1] == 0) {
                return A[i-1] + 1;
            }
        }
        // if the first positive integer has not started from the 0th element but from any other index
        // then the missing integer will be the last element plus 1
        if (pos != 0) {
            return A[A.length-1] + 1;
        }
        // if the first positive integer has started from the 0th element then the missing integer will
        // be the length of the array plus 1
        return A.length + 1;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    private static int solve1(int[] A) {
        // this map will store only the positive elements
        Map<Integer, Integer> pos = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i=0;i<A.length;i++) {
            if (A[i] > 0) {
                pos.put(A[i], i);
            }
            max = Math.max(max,A[i]);
        }
        // the range of missing positive integers will lie from 1 to A.length
        for (int i=1;i<=A.length;i++) {
            if (!pos.containsKey(i)) {
                return i;
            }
        }
        // if all the elements in the array are positive and are found in the hashmap
        // then max+1 will be the answer
        if (max == A.length) {
            return max+1;
        }
        return 1;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public int firstMissingPositive1(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        // put all the no.s into a hashmap
        for (int i=0;i<A.length;i++) {
            map.put(A[i], i);
        }
        // then check all the no.s from 1 to n+1, if it is present in the hashmap or not
        for (int i=1;i<=A.length+1;i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    private static int solve2(int[] A) {
        for (int i=0;i<A.length;i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != i+1) {
                // swap A[i] with A[A[i] - 1] only if both the values are different
                if (A[i] != A[A[i] - 1]) {
                    int temp = A[A[i] - 1];
                    A[A[i] - 1] = A[i];
                    A[i] = temp;
                } else {
                    break;
                }
            }
        }
        int i=0;
        while (i<A.length) {
            if (i != A[i] - 1) {
                return i+1;
            }
            i++;
        }
        // if all the elements in the array are positive and are at their correct places
        // then the missing element will be the last element + 1
        return i+1;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i=0;
        while (i < nums.length) {
            while (nums[i] != i+1) {
                int j = nums[i]-1;
                // duplicate
                if (nums[j] == nums[i]) {
                    break;
                }
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
        for (int k=0;k<nums.length;k++) {
            if (nums[k] != k+1) {
                ans.add(k+1);
            }
        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0) {
                nums[j] *= -1;
            }
        }
        for (int i=1;i<=nums.length;i++) {
            if (nums[i-1] > 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {2,3,-7,1,6,4,10,15,7};
//        int[] A = {1,1,1};
        System.out.println(solve(A));
    }
}
