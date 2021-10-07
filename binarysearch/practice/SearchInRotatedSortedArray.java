package binarysearch.practice;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        // no rotation
        if (nums[0] < nums[n-1]) {
            return search(nums, target, 0, n-1);
        }
        // find the pivot
        int p = pivot(nums);
        // if the target is equal to the pivot
        if (target == nums[p]) {
            return p;
        }
        if (target == nums[n-1]) {
            return n-1;
        }
        // target lies in the second half
        if (target < nums[n-1]) {
            return search(nums, target, p+1, n-1);
        }
        // target lies in the first half
        return search(nums, target, 0, p);
    }

    private static int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
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
            if ((mid == 0 || nums[mid-1] < nums[mid]) && (mid == n-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            // pivot will lie in the right side
            if (nums[mid] > nums[n-1]) {
                left = mid+1;
            }
            // pivot will lie in the left side
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
        int[] A = {3,1};
        System.out.println(search(A, 1));
    }
}
