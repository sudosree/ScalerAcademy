package binarysearch.practice;

public class FindPeak {

    private static int findPeak(int[] A) {
        int n = A.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if ((mid == 0 || A[mid] >= A[mid-1]) && (mid == n-1 || A[mid] >= A[mid+1])) {
                return A[mid];
            }
            // go to the left side as there can be a chance that the array is
            // sorted in decreasing order or it is a combination of both
            // increasing and decreasing sequence
            if (mid-1 >= 0 && A[mid-1] >= A[mid]) {
                high = mid-1;
            }
            // go to the right side as the array is sorted in increasing order or
            // combination of increasing and decreasing sequence
            else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        System.out.println(findPeak(A));
    }
}
