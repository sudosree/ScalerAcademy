package binarysearch.practice;

public class FindSingleOccurringElement {

    private static int findSingleElement(int[] A) {
        int n = A.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if ((mid == 0 || A[mid] > A[mid-1]) && (mid == n-1 || A[mid] < A[mid+1])) {
                return A[mid];
            }
            // mid is at odd position
            if ((mid & 1) == 1) {
                if (A[mid] == A[mid-1]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            // mid is at even position
            else {
                if (mid > 0 && A[mid] == A[mid-1]) {
                    high = mid-2;
                } else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            boolean halvesAreEven = (right - mid) % 2 == 0;
            if (nums[mid] == nums[mid+1]) {
                // case 1 : When the mid's partner is to the right and the halves were originally even
                if (halvesAreEven) {
                    left = mid + 2;
                }
                // case 2 : When the mid's partner is to the right and the halves were originally odd
                else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid-1]) {
                // case 3 : When the mid's partner is to the left and the halves were originally even
                if (halvesAreEven) {
                    right = mid - 2;
                }
                // case 4 : When the mid's partner is to the left and the halves were originally odd
                else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] A = {1,1,2,2,3,3,4,4,5,5,6,6,7,7};
        System.out.println(findSingleElement(A));
    }
}
