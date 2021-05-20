package binarysearch;

public class UpperBound {

    private static int findUpperBound(int[] A, int num) {
        int start = 0, end = A.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (A[mid] > num && (mid == 0 || A[mid-1] <= num)) {
                return mid;
            }
            if (num > A[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }

    private static int findUpperBound1(int[] A, int num) {
        int start = 0, end = A.length-1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (num >= A[mid]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] A = {2,3,6,8,12,15,18};
        System.out.println(findUpperBound1(A,7));
    }
}
