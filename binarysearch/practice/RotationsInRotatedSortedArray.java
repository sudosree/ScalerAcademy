package binarysearch.practice;

public class RotationsInRotatedSortedArray {


    private static int findPartition(int[] A) {
        // the array is not rotated, it is already in its proper sorted form
        int n = A.length;
        if (A[0] < A[n-1]) {
            return 0;
        }
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (mid-1 >= 0 && A[mid] < A[mid-1]) {
                return mid;
            }
            // partition will be on the right side
            if (A[mid] > A[n-1]) {
                low = mid+1;
            }
            // partition will be on the left side
            else {
                high = mid-1;
            }
        }
        return 0;
    }

    private static int findNoOfRotations(int[] A) {
        // find the pivot element's index A[i] s.t A[i-1] > A[i] < A[i+1] and
        // around which the partition has occured
        int pivot = findPartition(A);
        // no. of elements before the pivot is the no. of rotations
        return pivot;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(findNoOfRotations(A));
    }
}
