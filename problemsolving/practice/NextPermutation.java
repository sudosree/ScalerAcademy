package problemsolving.practice;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        // first find the index k such that nums[k] < nums[k+1]
        int k, n = nums.length;
        for (k=n-2; k>=0; k--) {
            if (nums[k] < nums[k+1]) {
                break;
            }
        }
        // all the elements are in descending order, it is the last permutation
        if (k < 0) {
            Arrays.sort(nums);
            return;
        }
        // find the index l s.t l > k and nums[k] < nums[l];
        int l;
        for (l=n-1; l>k; l--) {
            if (nums[l] > nums[k]) {
                break;
            }
        }
        // swap nums[k] and nums[l]
        int t = nums[k];
        nums[k] = nums[l];
        nums[l] = t;

        // reverse the part from nums[k+1..n-1]
        Arrays.sort(nums, k+1, n);
    }
}
