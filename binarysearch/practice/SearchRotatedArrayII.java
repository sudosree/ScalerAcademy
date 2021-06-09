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

    public static void main(String[] args) {
        int[] A = {4,4,4,4,4,4,4,5,0,1,2,4,4};
        System.out.println(search(A, 3));
    }
}
