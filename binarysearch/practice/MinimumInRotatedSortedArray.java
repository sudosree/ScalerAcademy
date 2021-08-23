package binarysearch.practice;

public class MinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return pivot != -1 ? nums[pivot] : pivot;
    }

    private int findPivot(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if ((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])) {
                return mid;
            }
            if (nums[mid] > nums[nums.length-1]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
