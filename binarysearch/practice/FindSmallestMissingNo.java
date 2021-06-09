package binarysearch.practice;

public class FindSmallestMissingNo {

    private static int findSmallestMissingNo(int[] A) {
        if (A[0] != 0) {
            return 0;
        }
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            // all the elements are present on the left side of mid from 0 to mid
            // so go to the right side
            if (mid == A[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        System.out.println(findSmallestMissingNo(A));
    }
}
