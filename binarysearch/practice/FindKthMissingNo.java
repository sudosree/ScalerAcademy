package binarysearch.practice;

public class FindKthMissingNo {

    private static int find(int[] A, int k) {
        int n = A.length;
        // if the kth missing no. is greater than the no. of missing
        // no.s till the last element
        int last = missing(A, n-1);
        if (k > last) {
            return A[n-1] + k - last;
        }
        int low = 0, high = n-1;
        // find the rightmost index such that missing(A, i) < k
        // and the missing no. = A[i] + k - missing(A, i)
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (missing(A, mid) < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return A[low-1] + k - missing(A, low-1);
    }

    private static int missing(int[] A, int i) {
        return A[i] - A[0] - i;
    }

    private static int findKthMissingNo(int[] A, int k) {
        return find(A, k);
    }

    public static void main(String[] args) {
        int[] A = {1,2,4};
        System.out.println(findKthMissingNo(A, 3));
    }
}
