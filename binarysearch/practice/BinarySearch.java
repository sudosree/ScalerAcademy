package binarysearch.practice;

public class BinarySearch {

    private static int binarySearch(int[] A, int x) {
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (A[mid] == x) {
                return mid;
            }
            if (A[mid] < x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    private static int binarySearchR(int[] A, int low, int high, int x) {
        if (low <= high) {
            int mid = low + (high-low)/2;
            if (A[mid] == x) {
                return mid;
            }
            if (A[mid] < x) {
                return binarySearchR(A, mid+1, high, x);
            }
            return binarySearchR(A, low, mid-1, x);
        }
        return -1;
    }

    private static int bs(int[] A, int x) {
        return binarySearchR(A, 0, A.length-1, x);
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9,10};
        int x = 9;
        System.out.println(binarySearch(A,x));
        System.out.println(bs(A, x));
    }
}
