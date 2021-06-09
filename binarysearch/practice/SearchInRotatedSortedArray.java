package binarysearch.practice;

public class SearchInRotatedSortedArray {

    private static int findInRotatedSortedArray(int[] A, int x) {
        int pivot = findPartition(A);
        int n = A.length;
        if (x == A[pivot]) {
            return pivot;
        }
        // the array is not rotated
        if (pivot == 0) {
            return binarySearch(A, 0, n-1, x);
        }
        // partition is on the right side of x, find x
        // in the left side of the partition
        if (x > A[n-1]) {
            return binarySearch(A, 0, pivot-1, x);
        }
        // partition is on the left side of x, find x
        // in the right side of the partition
        return binarySearch(A, pivot, n-1, x);
    }

    private static int findPartition(int[] A) {
        int n = A.length;
        // no partition i.e. the array is not rotated
        if (A[0] < A[n-1]) {
            return 0;
        }
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (mid-1 >= 0 && A[mid] < A[mid-1]) {
                return mid;
            }
            // partition will lie on the right side
            if (A[mid] > A[n-1]) {
                low = mid+1;
            }
            // partition will lie on the left side
            else {
                high = mid-1;
            }
        }
        return 0;
    }

    private static int binarySearch(int[] A, int low, int high, int x) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] == x) {
                return mid;
            }
            if (x > A[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
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
    private static int search(int[] A, int x) {
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] == x) {
                return mid;
            }
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
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {8,9,10,11,1,2,3,4,5};
        System.out.println(findInRotatedSortedArray(A, 6));
    }
}
