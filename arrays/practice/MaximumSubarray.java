package arrays.practice;

import java.util.*;

public class MaximumSubarray
{

    /**
     * TC = O(n)
     */
    private static int maximumSubarray(int[] A) {
        int local_max = 0, global_max = Integer.MIN_VALUE;
        for (int i=0;i<A.length;i++) {
            // local_max[i] = max(A[i], A[i] + local_max[i-1])
            // start a new sequence
            if (A[i] > local_max + A[i]) {
                local_max = A[i];
            }
            // continue with the existing sequence
            else {
                local_max += A[i];
            }
            global_max = Math.max(global_max, local_max);
        }
        return global_max;
    }

    private static int maximumSubarray1(int[] A) {
        int local_max = 0, global_max = Integer.MIN_VALUE;
        for (int i=0;i<A.length;i++) {
            local_max = Math.max(A[i], local_max + A[i]);
            global_max = Math.max(global_max, local_max);
        }
        return global_max;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int[] printMaximumSubarray(int[] A) {
        int local_max = 0, global_max = Integer.MIN_VALUE;
        int curr_start = 0, curr_end, best_start = -1, best_end = -1;
        for (int i=0;i<A.length;i++) {
            curr_end = i;
            if (A[i] > local_max + A[i]) {
                local_max = A[i];
                curr_start = i;
            } else {
                local_max += A[i];
            }
            if (local_max > global_max) {
                global_max = local_max;
                best_start = curr_start;
                best_end = curr_end;
            }
        }
        if (best_start == -1) {
            return new int[]{};
        }
        int[] res = new int[best_end - best_start + 1];
        for (int i=0,j=best_start;i<res.length;i++,j++) {
            res[i] = A[j];
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubarray(A));
        System.out.println(Arrays.toString(printMaximumSubarray(A)));
    }
}
