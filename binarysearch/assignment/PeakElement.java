package binarysearch.assignment;

public class PeakElement {

    /**
     * return peak element
     * @param A
     * @return
     */
    private static int solve(int[] A) {
        int left = 0, right = A.length-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if ((mid == 0 || A[mid] >= A[mid-1]) && (mid == A.length-1 || A[mid] >= A[mid+1])) {
                return A[mid];
            }
            if (mid > 0 && A[mid-1] >= A[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    /**
     * return the index and adjacent elements are not equal i.e. nums[i] != nums[i+1]
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            if (mid > 0 && nums[mid-1] > nums[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            // decreasing slope so peak will lie in the left side
            if (nums[mid] > nums[mid+1]) {
                right = mid;
            }
            // increasing slope peak will lie in the right side
            else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        System.out.println(findPeakElement(A));
    }
}
