package binarysearch.practice;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int p = pivot(nums);
        // if the array is not rotated
        if (p == -1) {
            return search(nums, 0, nums.length-1, target);
        }
        if (target == nums[p]) {
            return p;
        }
        // target lies in the 1st half
        if (target > nums[nums.length-1]) {
            return search(nums, 0, p, target);
        }
        return search(nums, p+1, nums.length-1, target);
    }

    private static int search(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    private static int pivot(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            // pivot lies in the right side
            if (nums[mid] > nums[n-1]) {
                left = mid+1;
            }
            // pivot lies in the left side
            else {
                right = mid-1;
            }
        }
        return -1;
    }

    /**
     * One pass binary search
     * @param A
     * @param x
     * @return
     */
    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            // when nums[mid] is in the 2nd half
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            // when nums[mid] > nums[right] i.e. when nums[mid] is in the first half
            else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {3,5,1};
        System.out.println(search(A, 1));
    }
}
