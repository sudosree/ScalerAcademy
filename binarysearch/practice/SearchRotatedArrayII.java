package binarysearch.practice;

public class SearchRotatedArrayII {

    private static boolean search(int[] A, int x) {
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] == x) {
                return true;
            }
            // tricky part because we do not know for sure in which part A[mid] lies,
            // it might lie in the 1st half or it might lie in the 2nd half, so we cannot find the
            // target in this case, so we have to reduce our search space until A[mid] != A[high]
            if (A[mid] == A[high]) {
                high--;
            }
            // A[mid] is in the 1st half
            else if (A[mid] > A[high]) {
                // x lies in the 1st half
                if (A[low] <= x && x < A[mid]) {
                    high = mid-1;
                }
                // x lies in the 2nd half
                else {
                    low = mid+1;
                }
            }
            // A[mid] is in the 2nd half
            else {
                // x lies in the 2nd half
                if (A[mid] < x && x <= A[high]) {
                    low = mid+1;
                }
                // x lies in the 1st half
                else {
                    high = mid-1;
                }
            }
        }
        return false;
    }

    public static boolean search1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // check if nums[mid] == nums[left] then difficult to find the position of target
            if (nums[mid] == nums[left]) {
                left++;
            }
            // when nums[mid] lies in F and
            else if (nums[mid] > nums[left]) {
                // when target lies in F then search in the first half
                if (target >= nums[left]) {
                    // in the first half check which one is smaller or larger
                    if (target > nums[mid]) {
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                }
                // when target lies in S then search in the second half
                else {
                    left = mid+1;
                }
            }
            // when nums[mid] lies in S and
            else {
                // when target lies in S then search in the second half
                if (target < nums[left]) {
                    // in the second half check which one is smaller or larger
                    if (target > nums[mid]) {
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                }
                // when target lies in F then search in the first half
                else {
                    right = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {4,4,4,4,4,4,4,5,0,1,2,4,4};
        System.out.println(search(A, 3));
    }
}
