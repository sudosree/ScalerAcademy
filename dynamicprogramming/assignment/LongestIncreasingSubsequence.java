package dynamicprogramming.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        return lis(nums, Integer.MIN_VALUE, 0);
    }

    /**
     * TC = O(2^n), SC = O(2^n)
     * @param nums
     * @param prev
     * @param currPos
     * @return
     */
    private int lis(int[] nums, int prev, int currPos) {
        // base case
        if (currPos ==  nums.length) {
            return 0;
        }
        int taken = 0;
        // if the current element is greater than the previous element
        // then include the current element in the lis and increase the length
        // of lis by 1
        if (nums[currPos] > prev) {
            taken = 1 + lis(nums, nums[currPos], currPos+1);
        }
        // if not then donot include the current element in the lis
        int notTaken = lis(nums, prev, currPos+1);
        return Math.max(taken, notTaken);
    }

    /**
     * TC = O(n^2), SC = O(n)
     */
    public static int lengthOfLIS1(int[] A) {
        int[] lis = new int[A.length];
        lis[0] = 1;
        int max_ans = 1;
        for (int i=1;i<A.length;i++) {
            int max = 0;
            lis[i] = 1;
            for (int j=0;j<i;j++) {
                if (A[j] < A[i]) {
                    max = Math.max(max, lis[j]);
                }
            }
            lis[i] = max + 1;
            max_ans = Math.max(max_ans, lis[i]);
        }
        return max_ans;
    }

    /**
     * TC = O(n^2), SC = O(n)
     */
    public static int lengthOfLIS2(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int max_ans = 1;
        for (int i=1;i<nums.length;i++) {
            lis[i] = 1;
            for (int j=0;j<i;j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
            max_ans = Math.max(max_ans, lis[i]);
        }
        return max_ans;
    }

    /**
     * TC = O(n^2), SC = O(n)
     */
    private static List<Integer> findLIS1(int[] nums) {
        int[] lis = new int[nums.length];
        // prev will store the index of the second last element in the longest increasing subsequence ending at i
        int[] prev = new int[nums.length];
        Arrays.fill(prev, -1);
        lis[0] = 1;
        // pos will store the last element's index in the longest increasing subsequence ending at i
        int max = 1, pos = 0;
        for (int i=1;i<nums.length;i++) {
            for (int j=0;j<i;j++) {
                if (nums[j] < nums[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
            }
            if (lis[i] > max) {
                max = lis[i];
                pos = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (pos != -1) {
            ans.add(nums[pos]);
            pos = prev[pos];
        }
        Collections.reverse(ans);
        return ans;
    }

    /**
     * TC = O(nlogn), SC = O(n)
     */
    public static int lengthOfLIS3(int[] A) {
        // lis will store the element at which the longest increasing
        // subsequence of length i terminates
        int[] lis = new int[A.length+1];
        Arrays.fill(lis, Integer.MAX_VALUE);
        lis[0] = Integer.MIN_VALUE;
        for (int i=0;i<A.length;i++) {
            int j = findUpperBound(lis, A[i]);
            lis[j] = A[i];
        }
        int len = 0;
        for (int i=0;i<lis.length;i++) {
            if (lis[i] < Integer.MAX_VALUE) {
                len = i;
            }
        }
        return len;
    }

    private static int findUpperBound(int[] A, int num) {
        int start = 0, end = A.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (A[mid] >= num && (mid == 0 || A[mid-1] < num)) {
                return mid;
            }
            if (num > A[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] A = {5, 5, 3, 2, 2, 4, 3, 5, 9, 6};
        System.out.println(lengthOfLIS1(A));
        System.out.println(findLIS1(A));
        System.out.println(lengthOfLIS2(A));
    }
}
