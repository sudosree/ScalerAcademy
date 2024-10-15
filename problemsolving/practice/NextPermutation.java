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

    public void nextPermutation1(int[] nums) {
        int n = nums.length;
        // find the least significant digit or the pivot element such that nums[pivot-1] < nums[pivot]
        int pivot = n-1;
        while (pivot >= 1 && nums[pivot-1] >= nums[pivot]) {
            pivot--;
        }
        // check if the given no.s in the array is the largest permutation seen so far
        if (pivot != 0) {
            int i = n-1;
            // find the best significant digit to swap nums[pivot-1] with
            while (nums[pivot-1] >= nums[i]) {
                i--;
            }
            swap(nums, pivot-1, i);
        }
        // sort the elements to the right of nums[pivot-1] in ascending order to get the next
        // smallest lexicographic permutation
        int left = pivot, right = n-1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
