package binarysearch.practice;

public class FirstAndLastOccurrence {

    private static void findFirstLastOccurrence(int[] A, int x) {
        int first = findFirstOccurrence(A, x);
        int last = findLastOccurrence(A, x);
        System.out.println("First occurrence : " + first);
        System.out.println("Last occurrence : " + last);
    }

    private static int findFirstOccurrence(int[] A, int x) {
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] == x && (mid == 0 || A[mid-1] < x)) {
                return mid;
            }
            if (A[mid] >= x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    private static int findLastOccurrence(int[] A, int x) {
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (A[mid] == x && (mid+1 == A.length-1 || A[mid+1] > x)) {
                return mid;
            }
            if (A[mid] <= x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {2,5,5,5,6,6,8,9,9,9};
        findFirstLastOccurrence(A, 3);
    }
}
