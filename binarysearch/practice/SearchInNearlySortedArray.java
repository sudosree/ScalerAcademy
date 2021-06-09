package binarysearch.practice;

public class SearchInNearlySortedArray {

    private static int search(int[] A, int x) {
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] == x) {
                return mid;
            }
            if (mid-1 >= 0 && A[mid-1] == x) {
                return mid-1;
            }
            if (mid+1 < A.length && A[mid+1] == x) {
                return mid+1;
            }
            if (x < A[mid]) {
                high = mid-2;
            } else {
                low = mid+2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 3, 5, 4, 7, 6, 8, 9};
        System.out.println(search(A, 10));
    }
}
