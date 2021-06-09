package binarysearch.practice;

public class FindFloorCeil {

    private static int findFloor(int[] A, int x) {
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] == x) {
                return mid;
            }
            if (A[mid] > x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low-1;
    }

    private static int findCeil(int[] A, int x) {
        int low = 0, high = A.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] == x) {
                return mid;
            }
            if (A[mid] > x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    private static int floor(int[] A, int x) {
        int idx = findFloor(A, x);
        return idx != -1 ? A[idx] : idx;
    }

    private static int ceil(int[] A, int x) {
        int idx = findCeil(A, x);
        return idx != A.length ? A[idx] : -1;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(floor(A, 0));
        System.out.println(ceil(A, 0));
    }
}
